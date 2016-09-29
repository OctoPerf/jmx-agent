package com.octoperf.metrics.windows.pdh;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.windows.pdh.api.WindowsMemoryMetrics;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.win32.Pdh;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.Set;

import static lombok.AccessLevel.PACKAGE;

@Component
@ConditionalOnBean(Pdh.class)
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhMemoryMetrics implements WindowsMemoryMetrics {
  private static final Set<String> FORMATTED_COUNTERS =ImmutableSet.of(
      "% Committed Bytes in Use"
  );

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getAvailableMBytes() {
    return raw("Available Mbytes");
  }

  @Override
  public double getPercentCommittedBytesInUse() {
    return formatted("% Committed Bytes in Use");
  }

  @Override
  public double getPoolNonPagedBytes() {
    return raw("Pool Nonpaged Bytes");
  }

  @Override
  public double getPoolPagedBytes() {
    return raw("Pool Paged Bytes");
  }

  @Override
  public double getPagesPerSec() {
    return perSecond("Pages per Second");
  }

  @Override
  public double getPageFaultsPerSec() {
    return perSecond("Page Faults/sec");
  }

  @Override
  public double getCommitLimit() {
    return raw("Commit Limit");
  }

  @Override
  public double getWriteCopiesPerSec() {
    return perSecond("Write Copies/sec");
  }

  @Override
  public double getCacheFaultsPerSec() {
    return perSecond("Cache Faults/sec");
  }

  @Override
  public double getDemandZeroFaultsPerSec() {
    return perSecond("Demand Zero Faults/sec");
  }

  @Override
  public double getPagesInputPerSec() {
    return perSecond("Pages Input/sec");
  }

  @Override
  public double getPageReadsPerSec() {
    return perSecond("Page Reads/sec");
  }

  @Override
  public double getPagesOutputPerSec() {
    return perSecond("Pages Output/sec");
  }

  @Override
  public double getPageWritesPerSec() {
    return perSecond("Page Writes/sec");
  }

  @Override
  public double getPoolPagedAllocs() {
    return raw("Pool Paged Allocs");
  }

  @Override
  public double getPoolNonPagedAllocs() {
    return raw("Pool Nonpaged Allocs");
  }

  @Override
  public double getCacheBytes() {
    return raw("Cache Bytes");
  }

  @Override
  public double getCacheBytesPeak() {
    return raw("Cache Bytes Peak");
  }

  @Override
  public double getPoolPagedResidentBytes() {
    return raw("Pool Paged Resident Bytes");
  }

  @Override
  public double getSystemCodeTotalBytes() {
    return raw("System Code Total Bytes");
  }

  @Override
  public double getSystemCodeResidentBytes() {
    return raw("System Code Resident Bytes");
  }

  @Override
  public double getSystemDriverTotalBytes() {
    return raw("System Driver Total Bytes");
  }

  @Override
  public double getSystemDriverResidentBytes() {
    return raw("System Driver Resident Bytes");
  }

  @Override
  public double getSystemCacheResidentBytes() {
    return raw("System Cache Resident Bytes");
  }

  @Override
  public double getFreeSystemPageTableEntries() {
    return raw("Free System Page Table Entries");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> raw(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double raw(final String counter) {
    return perfmon.getRawValue("Memory", counter);
  }

  private double formatted(final String counter) {
    return perfmon.getFormattedValues("Memory", FORMATTED_COUNTERS).get(counter);
  }
}
