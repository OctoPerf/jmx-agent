package com.octoperf.metrics.iis.pdh;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.cache.WebServiceCacheFileMetrics;
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
@Conditional({IsWindows.class, IsWindows.class})
public final class PdhWebServiceCacheFileMetrics implements WebServiceCacheFileMetrics {
  private static final String WS_CACHE = "Web Service Cache";
  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
    "URI Cache Hits %"
  );

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getActiveFlushedEntries() {
    return wsc("Active Flushed Entries");
  }

  @Override
  public double getCurrentFilesCached() {
    return wsc("Current Files Cached");
  }

  @Override
  public double getCurrentFileCacheMemoryUsage() {
    return wsc("Current File Cache Memory Usage");
  }

  @Override
  public double getFileCacheFlushes() {
    return wsc("File Cache Flushes");
  }

  @Override
  public double getFileCacheHits() {
    return wsc("File Cache Hits");
  }

  @Override
  public double getFileCacheMisses() {
    return wsc("File Cache Misses");
  }

  @Override
  public double getMaximumFileCacheMemoryUsage() {
    return wsc("Maximum File Cache Memory Usage");
  }

  @Override
  public double getPercentFileCacheHits() {
    return formatted("File Cache Hits %");
  }

  @Override
  public double getTotalFilesCached() {
    return wsc("Total Files Cached");
  }

  @Override
  public double getTotalFlushedFiles() {
    return wsc("Total Flushed Files");
  }

  private double wsc(final String counter) {
    return perfmon.getRawValue(WS_CACHE, counter);
  }

  private double formatted(final String counter) {
    return perfmon
      .getFormattedValues(WS_CACHE, FORMATTED_COUNTERS)
      .get(counter);
  }
}
