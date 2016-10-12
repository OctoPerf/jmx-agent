package com.octoperf.metrics.iis.pdh.web.service;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.pdh.IsIIS;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.win32.Win32Exception;
import org.springframework.context.annotation.Conditional;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.stereotype.Component;

import javax.management.JMException;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import static javax.management.ObjectName.quote;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Conditional({IsWindows.class, IsIIS.class})
final class PdhIISWebServices {
  private static final String WEB_SERVICE = "Web Service";
  private static final String OBJECT_NAME = "IIS:type=WebService,instance=%s,category=%s";

  PdhIISWebServices(
    final PerfmonQueryService perfmon,
    final GaugeService gauges,
    final AnnotationMBeanExporter exporter) throws Win32Exception, JMException {
    super();

    for(final String instance : perfmon.getInstances(WEB_SERVICE)) {
      exporter.registerManagedResource(new PdhWSByteMetrics(perfmon, gauges, instance), getObjectName("IO", instance));
      exporter.registerManagedResource(new PdhWSCGIMetrics(perfmon, gauges, instance), getObjectName("CGI", instance));
      exporter.registerManagedResource(new PdhWSConnectionMetrics(perfmon, gauges, instance), getObjectName("Connection", instance));
      exporter.registerManagedResource(new PdhWSErrorMetrics(perfmon, gauges, instance), getObjectName("Error", instance));
      exporter.registerManagedResource(new PdhWSFileMetrics(perfmon, gauges, instance), getObjectName("File", instance));
      exporter.registerManagedResource(new PdhWSRequestMetrics(perfmon, gauges, instance), getObjectName("Request", instance));
      exporter.registerManagedResource(new PdhWSUserMetrics(perfmon, gauges, instance), getObjectName("User", instance));
    }
  }

  private ObjectName getObjectName(final String name, final String instance) throws MalformedObjectNameException {
    return new ObjectName(String.format(OBJECT_NAME, quote(instance), name));
  }
}
