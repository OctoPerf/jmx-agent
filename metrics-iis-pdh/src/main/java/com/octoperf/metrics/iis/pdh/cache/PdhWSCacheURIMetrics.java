package com.octoperf.metrics.iis.pdh.cache;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.cache.WebServiceCacheURIMetrics;
import com.octoperf.metrics.iis.pdh.IsIIS;
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
@Conditional({IsWindows.class, IsIIS.class})
public final class PdhWSCacheURIMetrics implements WebServiceCacheURIMetrics {
  private static final String WS_CACHE = "Web Service Cache";
  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
      "URI Cache Hits %"
  );

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getCurrentURIsCached() {
    return ws("Current URIs Cached");
  }

  @Override
  public double getTotalFlushedURIs() {
    return ws("Total Flushed URIs");
  }

  @Override
  public double getTotalURIsCached() {
    return ws("Total URIs Cached");
  }

  @Override
  public double getURICacheHits() {
    return ws("URI Cache Hits");
  }

  @Override
  public double getURICacheMisses() {
    return ws("URI Cache Misses");
  }

  @Override
  public double getURICacheFlushes() {
    return ws("URI Cache Flushes");
  }

  @Override
  public double getPercentURICacheHits() {
    return formatted("URI Cache Hits %");
  }

  private double ws(final String counter) {
    return perfmon.getRawValue(format(WS_CACHE, counter), counter);
  }

  private double formatted(final String counter) {
    return perfmon
        .getFormattedValues(format(WS_CACHE, counter), FORMATTED_COUNTERS)
        .getOrDefault(counter, 0d);
  }
}
