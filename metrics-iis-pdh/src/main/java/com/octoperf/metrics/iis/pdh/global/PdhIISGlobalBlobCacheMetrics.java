package com.octoperf.metrics.iis.pdh.global;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.global.IISGlobalBlobCacheMetrics;
import com.octoperf.metrics.iis.pdh.IsIIS;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.Set;

import static lombok.AccessLevel.PACKAGE;

@Component
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Conditional({IsWindows.class, IsIIS.class})
public final class PdhIISGlobalBlobCacheMetrics implements IISGlobalBlobCacheMetrics {
  private static final String IIS_GLOBAL = "Internet Information Services Global";
  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
    "BLOB Cache Hits %"
  );

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getBLOBCacheFlushes() {
    return blob("BLOB Cache Flushes");
  }

  @Override
  public double getBLOBCacheHits() {
    return blob("BLOB Cache Hits");
  }

  @Override
  public double getBLOBCacheHitsPercent() {
    return formatted("BLOB Cache Hit %");
  }

  @Override
  public double getBLOBCacheMisses() {
    return blob("BLOB Cache Misses");
  }

  @Override
  public double getCurrentBLOBsCached() {
    return blob("Current BLOBs Cached");
  }

  @Override
  public double getTotalBLOBsCached() {
    return blob("Total BLOBs Cached");
  }

  @Override
  public double getTotalFlushedBLOBs() {
    return blob("Total Flushed BLOBs");
  }

  private double blob(final String counter) {
    return perfmon.getRawValue(IIS_GLOBAL, counter);
  }

  private double formatted(final String counter) {
    return perfmon
      .getFormattedValues(IIS_GLOBAL, FORMATTED_COUNTERS)
      .get(counter);
  }
}
