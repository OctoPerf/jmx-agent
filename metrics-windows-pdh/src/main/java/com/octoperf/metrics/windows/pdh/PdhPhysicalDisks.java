package com.octoperf.metrics.windows.pdh;

import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import com.octoperf.metrics.windows.pdh.api.WindowsPhysicalDiskMetrics;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.win32.Pdh;
import org.hyperic.sigar.win32.Win32Exception;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.stereotype.Component;

import javax.management.JMException;
import javax.management.ObjectName;
import java.util.List;

import static java.lang.String.format;
import static javax.management.ObjectName.quote;

@Slf4j
@Component
@ConditionalOnBean(Pdh.class)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
final class PdhPhysicalDisks {
  private static final String PHYSICAL_DISK = "PhysicalDisk";
  private static final String OBJECT_NAME = "Windows:type=%s,instance=%s";

  PdhPhysicalDisks(
      final PerfmonQueryService perfmon,
      final GaugeService gauges,
      final AnnotationMBeanExporter exporter) throws Win32Exception, JMException {
    super();

    final List<String> instances = perfmon.getInstances(PHYSICAL_DISK);
    log.info("Physical Disks: " + instances);
    for(final String instance: instances) {
      final ObjectName objectName = new ObjectName(format(OBJECT_NAME, PHYSICAL_DISK, quote(instance)));
      final WindowsPhysicalDiskMetrics metric = new PdhPhysicalDiskMetrics(perfmon, gauges, instance);
      exporter.registerManagedResource(metric, objectName);
    }
  }
}
