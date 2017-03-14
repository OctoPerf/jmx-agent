package com.octoperf.metrics.sqlserver.pdh;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.mssql.api.SqlServerPlanCacheMetrics;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.Set;

import static com.octoperf.metrics.sqlserver.pdh.IsSqlServer.SQL_SERVER;
import static lombok.AccessLevel.PACKAGE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhSqlServerPlanCacheMetrics implements SqlServerPlanCacheMetrics {
  private static final String NAME = SQL_SERVER + ":Plan Cache(%s)";

  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
    "Cache Hit Ratio"
  );

  @NonNull
  PerfmonQueryService perfmon;
  @Getter
  @NonNull
  String instance;

  @Override
  public double getCacheHitRatio() {
    return formatted("Cache Hit Ratio");
  }

  @Override
  public double getCacheHitRatioBase() {
    return planCache("Cache Hit Ratio Base");
  }

  @Override
  public double getCacheObjectCounts() {
    return planCache("Cache Object Counts");
  }

  @Override
  public double getCacheObjectsInUse() {
    return planCache("Cache Objects in use");
  }

  @Override
  public double getCachePages() {
    return planCache("Cache Pages");
  }

  private double planCache(final String counter) {
    return perfmon.getRawValue(String.format(NAME, instance), counter);
  }

  private double formatted(final String counter) {
    return perfmon
      .getFormattedValues(String.format(NAME, instance), FORMATTED_COUNTERS)
      .getOrDefault(counter, 0d);
  }
}
