package com.octoperf.metrics.sqlserver.pdh;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.mssql.api.SqlServerAccessMethodsMetrics;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import static com.octoperf.metrics.sqlserver.pdh.IsSqlServer.SQL_SERVER;
import static lombok.AccessLevel.PACKAGE;

@Component
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Conditional({IsWindows.class, IsSqlServer.class})
public final class PdhSqlServerAccessMethodsMetrics implements SqlServerAccessMethodsMetrics {
  private static final String ACCESS_METHODS = SQL_SERVER + ":Access Methods";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getForwardedRecordsPerSec() {
    return perSecond("Forwarded Records/sec");
  }

  @Override
  public double getFullScansPerSec() {
    return perSecond("Full Scans/sec");
  }

  @Override
  public double getIndexSearchesPerSec() {
    return perSecond("Index Searches/sec");
  }

  @Override
  public double getPageSplitsPerSec() {
    return perSecond("Page Splits/sec");
  }

  @Override
  public double getWorkfilesCreatedPerSec() {
    return perSecond("Workfiles Created/sec");
  }

  @Override
  public double getWorktablesCreatedPerSec() {
    return perSecond("Worktables Created/sec");
  }

  @Override
  public double getWorktablesFromCacheRatio() {
    return accessMethods("Worktables From Cache Ratio");
  }

  @Override
  public double getTableLockEscalationsPerSec() {
    return perSecond("Table Lock Escalations/sec");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> accessMethods(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double accessMethods(final String counter) {
    return perfmon.getRawValue(ACCESS_METHODS, counter);
  }
}
