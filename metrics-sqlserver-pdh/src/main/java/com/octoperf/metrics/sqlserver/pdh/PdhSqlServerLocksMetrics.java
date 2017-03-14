package com.octoperf.metrics.sqlserver.pdh;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.mssql.api.SqlServerLocksMetrics;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Conditional;

import static com.octoperf.metrics.sqlserver.pdh.IsSqlServer.SQL_SERVER;
import static java.lang.String.format;
import static lombok.AccessLevel.PACKAGE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Conditional({IsWindows.class, IsSqlServer.class})
public final class PdhSqlServerLocksMetrics implements SqlServerLocksMetrics {
  private static final String NAME = SQL_SERVER + ":Locks(%s)";

  @Getter
  @NonNull
  String instance;
  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getAverageWaitTimeMs() {
    return substracting("Average Wait Time (ms)");
  }

  @Override
  public double getLockRequestsPerSec() {
    return perSecond("Lock Requests/sec");
  }

  @Override
  public double getLockTimeouts() {
    return perSecond("Lock Timeouts/sec");
  }

  @Override
  public double getLockWaitTimeMs() {
    return substracting("Lock Wait Time (ms)");
  }

  @Override
  public double getLockWaitsPerSec() {
    return perSecond("Lock Waits/sec");
  }

  @Override
  public double getNumberOfDeadlocksPerSec() {
    return perSecond("Number Of Deadlocks/sec");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> locks(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double substracting(final String counter) {
    final Gauge gauge = () -> locks(counter);
    return gauges.cached(counter, gauges.substracting(gauge)).getValue();
  }

  private double locks(final String counter) {
    return perfmon.getRawValue(format(NAME, instance), counter);
  }

}
