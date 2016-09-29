package com.octoperf.metrics.sqlserver.pdh;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.win32.Win32Exception;
import org.springframework.context.annotation.Conditional;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.stereotype.Component;

import javax.management.JMException;
import javax.management.ObjectName;

import static com.octoperf.metrics.sqlserver.pdh.IsSqlServer.SQL_SERVER;
import static javax.management.ObjectName.quote;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Conditional({IsWindows.class, IsSqlServer.class})
final class PdhSqlServerDatabases {
  private static final String DATABASES = "Databases";
  private static final String SQL_SERVER_DATABASES = SQL_SERVER + ":" + DATABASES;
  private static final String OBJECT_NAME = "SQLServer:type=%s,instance=%s";

  PdhSqlServerDatabases(
    final PerfmonQueryService perfmon,
    final GaugeService gauges,
    final AnnotationMBeanExporter exporter) throws Win32Exception, JMException {
    super();

    for(final String instance : perfmon.getInstances(SQL_SERVER_DATABASES)) {
      final ObjectName objectName = new ObjectName(String.format(OBJECT_NAME, DATABASES, quote(instance)));
      final PdhSqlServerDatabaseMetrics metric = new PdhSqlServerDatabaseMetrics(perfmon, gauges, instance);
      exporter.registerManagedResource(metric, objectName);
    }
  }
}
