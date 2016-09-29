package com.octoperf.metrics.windows.pdh;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import com.octoperf.metrics.windows.pdh.api.WindowsPhysicalDiskMetrics;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.Set;

import static java.lang.String.format;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhPhysicalDiskMetrics implements WindowsPhysicalDiskMetrics {
  private static final String PHYSICAL_DISK = "PhysicalDisk(%s)";
  private static final Set<String> COUNTERS = ImmutableSet.of(
      "% Disk Time",
      "Avg. Disk Queue Length",
      "% Disk Read Time",
      "Avg. Disk Read Queue Length",
      "% Disk Write Time",
      "Avg. Disk Write Queue Length",
      "Avg. Disk sec/Transfer",
      "Avg. Disk sec/Read",
      "Avg. Disk sec/Write",
      "Avg. Disk Bytes/Transfer",
      "Avg. Disk Bytes/Read",
      "Avg. Disk Bytes/Write",
      "% Idle Time"
  );

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @NonNull
  String instance;

  @Override
  public String getInstance() {
    return instance;
  }

  @Override
  public double getCurrentDiskQueueLength() {
    return raw("Current Disk Queue Length");
  }

  @Override
  public double getPercentDiskTime() {
    return formatted("% Disk Time");
  }

  @Override
  public double getAverageDiskQueueLength() {
    return formatted("Avg. Disk Queue Length");
  }

  @Override
  public double getPercentDiskReadTime() {
    return formatted("% Disk Read Time");
  }

  @Override
  public double getAverageDiskReadQueueLength() {
    return formatted("Avg. Disk Read Queue Length");
  }

  @Override
  public double getPercentDiskWriteTime() {
    return formatted("% Disk Write Time");
  }

  @Override
  public double getAverageDiskWriteQueueLength() {
    return formatted("Avg. Disk Write Queue Length");
  }

  @Override
  public double getAverageDiskSecPerTransfer() {
    return formatted("Avg. Disk sec/Transfer");
  }

  @Override
  public double getAverageDiskSecondPerRead() {
    return formatted("Avg. Disk sec/Read");
  }

  @Override
  public double getAverageDiskSecondPerWrite() {
    return formatted("Avg. Disk sec/Write");
  }

  @Override
  public double getDiskTransfersPerSec() {
    return perSecond("Disk Transfers/sec");
  }

  @Override
  public double getDiskReadsPerSec() {
    return perSecond("Disk Reads/sec");
  }

  @Override
  public double getDiskWritesPerSec() {
    return perSecond("Disk Writes/sec");
  }

  @Override
  public double getDiskBytesPerSec() {
    return perSecond("Disk Bytes/sec");
  }

  @Override
  public double getDiskReadBytesPerSec() {
    return perSecond("Disk Read Bytes/sec");
  }

  @Override
  public double getDiskWriteBytesPerSec() {
    return perSecond("Disk Write Bytes/sec");
  }

  @Override
  public double getAverageDiskBytesPerTransfer() {
    return formatted("Avg. Disk Bytes/Transfer");
  }

  @Override
  public double getAverageDiskBytesPerRead() {
    return formatted("Avg. Disk Bytes/Read");
  }

  @Override
  public double getAverageDiskBytesPerWrite() {
    return formatted("Avg. Disk Bytes/Write");
  }

  @Override
  public double getPercentIdleTime() {
    return formatted("% Idle Time");
  }

  @Override
  public double getSplitIOPerSec() {
    return perSecond("Split IO/Sec");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> raw(counter);
    return gauges.cached(instance + counter, gauges.perSecond(gauge)).getValue();
  }

  private double raw(final String counter) {
    return perfmon.getRawValue(diskInstance(), counter);
  }

  private double formatted(final String counter) {
    return perfmon.getFormattedValues(diskInstance(), COUNTERS).get(counter);
  }

  private String diskInstance() {
    return format(PHYSICAL_DISK, instance);
  }
}
