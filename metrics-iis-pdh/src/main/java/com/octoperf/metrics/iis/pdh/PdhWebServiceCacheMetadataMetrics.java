package com.octoperf.metrics.iis.pdh;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.cache.WebServiceCacheMetadataMetrics;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.lang.String.format;
import static lombok.AccessLevel.PACKAGE;

@Component
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Conditional({IsWindows.class, IsWindows.class})
public final class PdhWebServiceCacheMetadataMetrics implements WebServiceCacheMetadataMetrics {
  private static final String WS_CACHE = "Web Service Cache";
  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
    "Metadata Cache Hits %"
  );

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getCurrentMetadataCached() {
    return ws("Current Metadata Cached");
  }

  @Override
  public double getTotalFlushedMetadata() {
    return ws("Total Flushed Metadata");
  }

  @Override
  public double getTotalMetadataCached() {
    return ws("Total Metadata Cached");
  }

  @Override
  public double getMetadataCacheHits() {
    return ws("Metadata Cache Hits");
  }

  @Override
  public double getMetadataCacheMisses() {
    return ws("Metadata Cache Misses");
  }

  @Override
  public double getMetadataCacheFlushes() {
    return ws("Metadata Cache Flushes");
  }

  @Override
  public double getPercentMetadataCacheHits() {
    return formatted("Metadata Cache Hits %");
  }

  private double ws(final String counter) {
    return perfmon.getRawValue(format(WS_CACHE, counter), counter);
  }

  private double formatted(final String counter) {
    return perfmon
      .getFormattedValues(format(WS_CACHE, counter), FORMATTED_COUNTERS)
      .get(counter);
  }
}
