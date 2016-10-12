package com.octoperf.metrics.iis.pdh;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.KernelURIMetrics;
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

import static lombok.AccessLevel.PACKAGE;

@Component
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Conditional({IsWindows.class, IsIIS.class})
public final class PdhKernelURIMetrics implements KernelURIMetrics {
  private static final String KERNEL = "Kernel";
  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
    "URI Cache Hits %"
  );

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getCurrentURIsCached() {
    return kernel("Current URIs Cached");
  }

  @Override
  public double getPercentURICacheHits() {
    return formatted("URI Cache Hits %");
  }

  @Override
  public double getTotalFlushedURIs() {
    return kernel("Total Flushed URIs");
  }

  @Override
  public double getTotalURIsCached() {
    return kernel("Total URIs Cached");
  }

  @Override
  public double getURICacheFlushes() {
    return kernel("URI Cache Flushes");
  }

  @Override
  public double getURICacheHits() {
    return kernel("URI Cache Hits");
  }

  @Override
  public double getURICacheHitsPerSec() {
    return perSecond("URI Cache Hits/sec");
  }

  @Override
  public double getURICacheMisses() {
    return kernel("URI Cache Misses");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> kernel(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double kernel(final String counter) {
    return perfmon.getRawValue(KERNEL, counter);
  }

  private double formatted(final String counter) {
    return perfmon
      .getFormattedValues(KERNEL, FORMATTED_COUNTERS)
      .get(counter);
  }
}
