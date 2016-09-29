package com.octoperf.metrics.sqlserver.pdh;

import com.octoperf.metrics.mssql.api.SqlServerPlanCacheMetrics;
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
public final class PdhSqlServerPlanCacheMetrics implements SqlServerPlanCacheMetrics {
  private static final String NAME = SQL_SERVER + ":Plan Cache(%s)";

  @NonNull
  PerfmonQueryService perfmon;
  @Getter
  @NonNull
  String instance;

  @Override
  public double getCacheHitRatio() {
    return planCache("Cache Hit Ratio");
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
}
