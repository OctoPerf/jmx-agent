package com.octoperf.metrics.sqlserver.pdh;

import com.octoperf.metrics.mssql.api.SqlServerDatabaseMetrics;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import static com.octoperf.metrics.sqlserver.pdh.IsSqlServer.SQL_SERVER;
import static lombok.AccessLevel.PACKAGE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhSqlServerDatabaseMetrics implements SqlServerDatabaseMetrics {
  private static final String DATABASES = SQL_SERVER + ":Databases(%s)";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @Getter
  @NonNull
  String instance;

  @Override
  public double getDataFilesSizeKB() {
    return databases("Data File(s) Size (KB)");
  }

  @Override
  public double getLogBytesFlushedPerSec() {
    return perSecond("Log Bytes Flushed/sec");
  }

  @Override
  public double getLogFilesSizeKB() {
    return databases("Log File(s) Size (KB)");
  }

  @Override
  public double getLogFilesUsedSizeKB() {
    return databases("Log File(s) Used Size (KB)");
  }

  @Override
  public double getLogFlushWaitTime() {
    return databases("Log Flush Wait Time");
  }

  @Override
  public double getLogFlushWaitsPerSec() {
    return perSecond("Log Flush Waits/sec");
  }

  @Override
  public double getLogFlushesPerSec() {
    return perSecond("Log Flushes/sec");
  }

  @Override
  public double getLogGrowths() {
    return databases("Log Growths");
  }

  @Override
  public double getLogShrinks() {
    return databases("Log Shrinks");
  }

  @Override
  public double getLogTruncations() {
    return databases("Log Truncations");
  }

  @Override
  public double getPercentLogUsed() {
    return databases("Percent Log Used");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> databases(counter);
    return gauges.cached(instance + counter, gauges.perSecond(gauge)).getValue();
  }

  private double databases(final String counter) {
    return perfmon.getRawValue(String.format(DATABASES, instance), counter);
  }
}
