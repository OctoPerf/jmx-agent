package com.octoperf.metrics.windows.pdh;

import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import com.octoperf.metrics.windows.pdh.api.WindowsProcessMetrics;
import com.octoperf.metrics.windows.pdh.api.WindowsSystemMetrics;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.win32.Pdh;
import org.hyperic.sigar.win32.Win32Exception;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.stereotype.Component;

import javax.management.JMException;
import javax.management.ObjectName;

import static java.lang.String.format;
import static javax.management.ObjectName.quote;

@Component
@ConditionalOnBean(Pdh.class)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
final class PdhProcesses {
  private static final String PROCESS = "Process";
  private static final String OBJECT_NAME = "Windows:type=%s,instance=%s";

  PdhProcesses(
    final PerfmonQueryService perfmon,
    final GaugeService gauges,
    final WindowsSystemMetrics system,
    final AnnotationMBeanExporter exporter) throws Win32Exception, JMException {
    super();

    for (final String instance : perfmon.getInstances(PROCESS)) {
      final ObjectName objectName = new ObjectName(format(OBJECT_NAME, PROCESS, quote(instance)));
      final WindowsProcessMetrics metric = new PdhProcessMetrics(perfmon, gauges, instance, system);
      exporter.registerManagedResource(metric, objectName);
    }
  }
}
