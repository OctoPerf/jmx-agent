package com.octoperf.metrics.sigar.disk;

import com.octoperf.metrics.service.api.CachingService;
import com.octoperf.metrics.service.api.UnitConversionService;
import com.octoperf.metrics.condition.IsNotWindows;
import javaslang.control.Try;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.context.annotation.Conditional;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.stereotype.Service;

import javax.management.JMException;
import javax.management.ObjectName;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

@Service
@Conditional(IsNotWindows.class)
final class FileSystems {

  static final String OBJECT_NAME = "Sigar:type=Filesystem,category=%s,name=%s";

  FileSystems(
    final UnitConversionService units,
    final CachingService caching,
    final Sigar sigar,
    final AnnotationMBeanExporter server) throws SigarException, JMException {
    final Set<String> seenFs = new HashSet<>();
    for(final FileSystem fs : sigar.getFileSystemList()) {
      final String devName = fs.getDevName();
      if(seenFs.contains(devName)) {
        continue;
      }
      seenFs.add(devName);

      final Try.CheckedSupplier<FileSystemUsage> supplier = caching
        .cache(() -> sigar.getFileSystemUsage(fs.getDirName()));

      final SigarFileSystemMetrics filesystem = SigarFileSystemMetrics
        .builder()
        .units(units)
        .usage(supplier)
        .devName(devName)
        .dirName(fs.getDirName())
        .options(fs.getOptions())
        .sysTypeName(fs.getSysTypeName())
        .build();

      final FilesystemType type = FilesystemType.values()[fs.getType()];
      final ObjectName objectName = new ObjectName(format(OBJECT_NAME, type, ObjectName.quote(devName)));
      server.registerManagedResource(filesystem, objectName);
    }
  }
}
