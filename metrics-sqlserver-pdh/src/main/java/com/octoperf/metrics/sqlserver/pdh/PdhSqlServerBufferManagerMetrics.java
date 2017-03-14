package com.octoperf.metrics.sqlserver.pdh;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.mssql.api.SqlServerBufferManagerMetrics;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.octoperf.metrics.sqlserver.pdh.IsSqlServer.SQL_SERVER;
import static lombok.AccessLevel.PACKAGE;

@Component
@Conditional({IsWindows.class, IsSqlServer.class})
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhSqlServerBufferManagerMetrics implements SqlServerBufferManagerMetrics {
  private static final String BUFFER_MANAGER = SQL_SERVER + ":Buffer Manager";

  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
    "Buffer Cache Hit Ratio"
  );

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getFreeListStallsPerSec() {
    return perSecond("Free List Stalls/sec");
  }

  @Override
  public double getLazyWritesPerSec() {
    return perSecond("Lazy Writes/sec");
  }

  @Override
  public double getCheckpointPagesPerSec() {
    return perSecond("Checkpoint Pages/sec");
  }

  @Override
  public double getPageLifeExpectancy() {
    return bufferManager("Page Life Expectancy");
  }

  @Override
  public double getPageLookupsPerSec() {
    return perSecond("Page Lookups/sec");
  }

  @Override
  public double getPageReadsPerSec() {
    return perSecond("Page Reads/sec");
  }

  @Override
  public double getPageWritesPerSec() {
    return perSecond("Page Writes/sec");
  }

  @Override
  public double getReadaheadPerSec() {
    return perSecond("Readahead/sec");
  }

  @Override
  public double getDatabasePages() {
    return bufferManager("Database Pages");
  }

  @Override
  public double getTargetPages() {
    return bufferManager("Target Pages");
  }

  @Override
  public double getBufferCacheHitRatio() {
    return formatted("Buffer Cache Hit Ratio");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> bufferManager(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double bufferManager(final String counter) {
    return perfmon.getRawValue(BUFFER_MANAGER, counter);
  }

  private double formatted(final String counter) {
    return perfmon
      .getFormattedValues(BUFFER_MANAGER, FORMATTED_COUNTERS)
      .getOrDefault(counter, 0d);
  }
}
