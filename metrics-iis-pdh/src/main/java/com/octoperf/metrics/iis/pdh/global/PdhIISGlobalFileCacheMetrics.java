package com.octoperf.metrics.iis.pdh.global;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.global.IISGlobalFileCacheMetrics;
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
public final class PdhIISGlobalFileCacheMetrics implements IISGlobalFileCacheMetrics {
  private static final String IIS_GLOBAL = "Internet Information Services Global";
  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
      "File Cache Hits %"
  );

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getCurrentFileCacheMemoryUsage() {
    return file("Current File Cache Memory Usage");
  }

  @Override
  public double getCurrentFilesCached() {
    return file("Current Files Cached");
  }

  @Override
  public double getFileCacheFlushes() {
    return file("File Cache Flushes");
  }

  @Override
  public double getFileCacheHits() {
    return file("File Cache Hits");
  }

  @Override
  public double getFileCacheHitsPercent() {
    return formatted("File Cache Hits %");
  }

  @Override
  public double getFileCacheMisses() {
    return file("File Cache Misses");
  }

  @Override
  public double getMaximumFileCacheMemoryUsage() {
    return file("Maximum File Cache Memory Usage");
  }

  @Override
  public double getTotalFilesCached() {
    return file("Total File Cached");
  }

  private double file(final String counter) {
    return perfmon.getRawValue(IIS_GLOBAL, counter);
  }

  private double formatted(final String counter) {
    return perfmon
        .getFormattedValues(IIS_GLOBAL, FORMATTED_COUNTERS)
        .getOrDefault(counter, 0d);
  }
}
