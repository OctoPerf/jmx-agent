package com.octoperf.metrics.windows.pdh;

import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
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
final class PdhProcessors {
  public static final String PROCESSOR = "Processor";
  private static final String OBJECT_NAME = "Windows:type=%s,instance=%s";

  PdhProcessors(
    final PerfmonQueryService perfmon,
    final GaugeService gauges,
    final AnnotationMBeanExporter exporter) throws Win32Exception, JMException {
    super();

    for(final String instance: perfmon.getInstances(PROCESSOR)) {
      final ObjectName objectName = new ObjectName(format(OBJECT_NAME, PROCESSOR, quote(instance)));
      final PdhProcessorMetrics metric = new PdhProcessorMetrics(perfmon, gauges, instance);
      exporter.registerManagedResource(metric, objectName);
    }
  }
}
