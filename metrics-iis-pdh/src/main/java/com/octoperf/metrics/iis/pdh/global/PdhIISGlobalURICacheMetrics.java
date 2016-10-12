package com.octoperf.metrics.iis.pdh.global;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.global.IISGlobalURICacheMetrics;
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
public final class PdhIISGlobalURICacheMetrics implements IISGlobalURICacheMetrics {
  private static final String IIS_GLOBAL = "Internet Information Services Global";
  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
    "URI Cache Hits %"
  );

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getCurrentURIsCached() {
    return uri("Current URIs Cached");
  }

  @Override
  public double getURICacheFlushes() {
    return uri("URI Cache Flushes");
  }

  @Override
  public double getURICacheHits() {
    return uri("URI Cache Hits");
  }

  @Override
  public double getURICacheHitsPercent() {
    return formatted("URI Cache Hits %");
  }

  @Override
  public double getTotalURIsCached() {
    return uri("Total URI Cached");
  }

  @Override
  public double getActiveFlushedEntries() {
    return uri("Active Flushed Entries");
  }

  @Override
  public double getTotalFlushedFiles() {
    return uri("Total Flushed Files");
  }

  @Override
  public double getTotalFlushedURIs() {
    return uri("Total Flushed URIs");
  }

  @Override
  public double getURICacheMisses() {
    return uri("URI Cache Misses");
  }

  private double uri(final String counter) {
    return perfmon.getRawValue(IIS_GLOBAL, counter);
  }

  private double formatted(final String counter) {
    return perfmon
      .getFormattedValues(IIS_GLOBAL, FORMATTED_COUNTERS)
      .get(counter);
  }
}
