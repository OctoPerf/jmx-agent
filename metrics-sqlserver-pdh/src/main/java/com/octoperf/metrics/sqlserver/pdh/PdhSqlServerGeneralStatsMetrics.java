package com.octoperf.metrics.sqlserver.pdh;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.mssql.api.SqlServerGeneralStatsMetrics;
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
public final class PdhSqlServerGeneralStatsMetrics implements SqlServerGeneralStatsMetrics {
  private static final String NAME = SQL_SERVER + ":General Statistics";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;


  @Override
  public double getLoginsPerSec() {
    return perSecond("Logins/sec");
  }

  @Override
  public double getLogoutsPerSec() {
    return perSecond("Logouts/sec");
  }

  @Override
  public double getConnectionResetsPerSec() {
    return perSecond("Connection resets/sec");
  }

  @Override
  public double getProcessesBlocked() {
    return generalStats("Processes Blocked");
  }

  @Override
  public double getUserConnections() {
    return generalStats("User Connections");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> generalStats(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double generalStats(final String counter) {
    return perfmon.getRawValue(NAME, counter);
  }
}
