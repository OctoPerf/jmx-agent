package com.octoperf.metrics.sqlserver.pdh;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.mssql.api.SqlServerSqlStatsMetrics;
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
@Conditional({IsWindows.class, IsSqlServer.class})
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhSqlServerSQLStatsMetrics implements SqlServerSqlStatsMetrics {
  private static final String SQL_STATISTICS = SQL_SERVER + ":SQL Statistics";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getAutoParamAttemptsPerSec() {
    return perSecond("Auto-Param Attempts/sec");
  }

  @Override
  public double getFailedAutoParamsPerSec() {
    return perSecond("Failed Auto-Params/sec");
  }

  @Override
  public double getSafeAutoParamsPerSec() {
    return perSecond("Safe Auto-Params/sec");
  }

  @Override
  public double getUnsafeAutoParamsPerSec() {
    return perSecond("Unsafe Auto-Params/sec");
  }

  @Override
  public double getBatchRequestsPerSec() {
    return perSecond("Batch Requests/sec");
  }

  @Override
  public double getSQLAttentionsPerSec() {
    return perSecond("SQL Attention Rate");
  }

  @Override
  public double getSQLCompilationsPerSec() {
    return perSecond("SQL Compilations/sec");
  }

  @Override
  public double getSQLReCompilationsPerSec() {
    return perSecond("SQL Re-Compilations/sec");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> bufferManager(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double bufferManager(final String counter) {
    return perfmon.getRawValue(SQL_STATISTICS, counter);
  }
}
