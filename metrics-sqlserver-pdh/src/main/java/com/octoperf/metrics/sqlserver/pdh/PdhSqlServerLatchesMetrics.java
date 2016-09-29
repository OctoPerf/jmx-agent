package com.octoperf.metrics.sqlserver.pdh;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.mssql.api.SqlServerLatchesMetrics;
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
public final class PdhSqlServerLatchesMetrics implements SqlServerLatchesMetrics {
  private static final String NAME = SQL_SERVER + ":Latches";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getAverageLatchWaitTimeMs() {
    return latches("Average Latch Wait Time (ms)");
  }

  @Override
  public double getLatchWaitsPerSec() {
    return perSecond("Latch Waits/sec");
  }

  @Override
  public double getNumberOfSuperLatches() {
    return latches("Number of SuperLatches");
  }

  @Override
  public double getSuperLatchDemotionsPerSec() {
    return perSecond("SuperLatch Demotions/sec");
  }

  @Override
  public double getSuperLatchPromotionsPerSec() {
    return perSecond("SuperLatch Promotions/sec");
  }

  @Override
  public double getTotalLatchWaitTimeMs() {
    return perSecond("Total Latch Wait Time (ms)");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> latches(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double latches(final String counter) {
    return perfmon.getRawValue(NAME, counter);
  }
}
