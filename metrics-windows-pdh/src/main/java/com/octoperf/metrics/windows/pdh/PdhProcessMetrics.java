package com.octoperf.metrics.windows.pdh;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.windows.pdh.api.WindowsProcessMetrics;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.Set;

import static java.lang.String.format;
import static lombok.AccessLevel.PACKAGE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhProcessMetrics implements WindowsProcessMetrics {
  private static final String PROCESS = "Process(%s)";
  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
      "% Processor Time",
      "% User Time",
      "% Privileged Time",
      "Elapsed Time"
  );

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @NonNull
  @Getter
  String instance;

  @Override
  public double getPercentProcessorTime() {
    return formatted("% Processor Time");
  }

  @Override
  public double getPercentUserTime() {
    return formatted("% User Time");
  }

  @Override
  public double getPercentPrivilegedTime() {
    return formatted("% Privileged Time");
  }

  @Override
  public double getVirtualBytesPeak() {
    return raw("Virtual Bytes Peak");
  }

  @Override
  public double getVirtualBytes() {
    return raw("Virtual Bytes");
  }

  @Override
  public double getPageFaultsPerSec() {
    return perSecond("Page Faults/sec");
  }

  @Override
  public double getWorkingSetPeak() {
    return raw("Working Set Peak");
  }

  @Override
  public double getWorkingSet() {
    return raw("Working Set");
  }

  @Override
  public double getPageFileBytesPeak() {
    return raw("Page File Bytes Peak");
  }

  @Override
  public double getPageFileBytes() {
    return raw("Page File Bytes");
  }

  @Override
  public double getPrivateBytes() {
    return raw("Private Bytes");
  }

  @Override
  public double getThreadCount() {
    return raw("Thread Count");
  }

  @Override
  public double getPriorityBase() {
    return raw("Priority Base");
  }

  @Override
  public double getElapsedTime() {
    return formatted("Elapsed Time");
  }

  @Override
  public double getIDProcess() {
    return raw("ID Process");
  }

  @Override
  public double getCreatingProcessID() {
    return raw("Creating Process ID");
  }

  @Override
  public double getPoolPagedBytes() {
    return raw("Pool Paged Bytes");
  }

  @Override
  public double getPoolNonpagedBytes() {
    return raw("Pool Nonpaged Bytes");
  }

  @Override
  public double getHandleCount() {
    return raw("Handle Count");
  }

  @Override
  public double getIOReadOperationsPerSec() {
    return perSecond("IO Read Operations/sec");
  }

  @Override
  public double getIOWriteOperationsPerSec() {
    return perSecond("IO Write Operations/sec");
  }

  @Override
  public double getIODataOperationsPerSec() {
    return perSecond("IO Data Operations/sec");
  }

  @Override
  public double getIOOtherOperationsPerSec() {
    return perSecond("IO Other Operations/sec");
  }

  @Override
  public double getIOReadBytesPerSec() {
    return perSecond("IO Read Bytes/sec");
  }

  @Override
  public double getIOWriteBytesPerSec() {
    return perSecond("IO Write Bytes/sec");
  }

  @Override
  public double getIODataBytesPerSec() {
    return perSecond("IO Data Bytes/sec");
  }

  @Override
  public double getIOOtherBytesPerSec() {
    return perSecond("IO Other Bytes/sec");
  }

  @Override
  public double getWorkingSetPrivate() {
    return raw("Working Set - Private");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> raw(counter);
    return gauges.cached(instance + counter, gauges.perSecond(gauge)).getValue();
  }

  private double raw(final String counter) {
    return perfmon.getRawValue(format(PROCESS, instance), counter);
  }

  private double formatted(final String counter) {
    return perfmon.getFormattedValues(
        format(PROCESS, instance),
        FORMATTED_COUNTERS)
        .get(counter);
  }
}
