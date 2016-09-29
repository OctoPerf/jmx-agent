package com.octoperf.metrics.sqlserver.pdh;

import com.octoperf.metrics.condition.IsWindows;
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
final class PdhSqlServerPlanCaches {
  private static final String PLAN_CACHE = "Plan Cache";
  private static final String OBJECT_NAME = "SQLServer:type=PlanCaches,instance=%s";

  PdhSqlServerPlanCaches(
    final PerfmonQueryService perfmon,
    final AnnotationMBeanExporter exporter) throws Win32Exception, JMException {
    super();

    for(final String instance : perfmon.getInstances(SQL_SERVER + ":" + PLAN_CACHE)) {
      final ObjectName objectName = new ObjectName(String.format(OBJECT_NAME, quote(instance)));
      final PdhSqlServerPlanCacheMetrics metric = new PdhSqlServerPlanCacheMetrics(perfmon, instance);
      exporter.registerManagedResource(metric, objectName);
    }
  }
}
