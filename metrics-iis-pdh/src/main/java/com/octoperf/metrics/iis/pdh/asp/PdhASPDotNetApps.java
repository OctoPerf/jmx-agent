package com.octoperf.metrics.iis.pdh.asp;

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
final class PdhASPDotNetApps {
  private static final String ASP_DOT_NET_APPS = "ASP.NET Applications";
  private static final String OBJECT_NAME = "IIS:type=%s,instance=%s";

  PdhASPDotNetApps(
    final PerfmonQueryService perfmon,
    final GaugeService gauges,
    final AnnotationMBeanExporter exporter) throws Win32Exception, JMException {
    super();

    for(final String instance : perfmon.getInstances(ASP_DOT_NET_APPS)) {
      exporter.registerManagedResource(new PdhASPDotNetAppMetrics(perfmon, gauges, instance), getObjectName(instance));
    }
  }

  private ObjectName getObjectName(final String instance) throws MalformedObjectNameException {
    return new ObjectName(String.format(OBJECT_NAME, ASP_DOT_NET_APPS, quote(instance)));
  }
}
