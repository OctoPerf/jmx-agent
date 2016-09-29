package com.octoperf.metrics.windows.pdh.api;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public interface WindowsPhysicalDiskMetrics {

  @ManagedAttribute(description = "Physical Disk instance.")
  String getInstance();

  @ManagedMetric(
    displayName = "Current Disk Queue Length",
    unit = "length",
    description = "Current Disk Queue Length")
  double getCurrentDiskQueueLength();

  @ManagedMetric(
    displayName = "% Disk Time",
    unit = "%",
    description = "% Disk Time")
  double getPercentDiskTime();

  @ManagedMetric(
    displayName = "Avg. Disk Queue Length",
    unit = "length",
    description = "Avg. Disk Queue Length")
  double getAverageDiskQueueLength();

  @ManagedMetric(
    displayName = "% Disk Read Time",
    unit = "length",
    description = "% Disk Read Time")
  double getPercentDiskReadTime();

  @ManagedMetric(
    displayName = "Avg. Disk Read Queue Length",
    unit = "length",
    description = "Avg. Disk Read Queue Length")
  double getAverageDiskReadQueueLength();

  @ManagedMetric(
    displayName = "% Disk Write Time",
    unit = "%",
    description = "% Disk Write Time")
  double getPercentDiskWriteTime();

  @ManagedMetric(
    displayName = "Avg. Disk Write Queue Length",
    unit = "length",
    description = "Avg. Disk Write Queue Length")
  double getAverageDiskWriteQueueLength();

  @ManagedMetric(
    displayName = "Avg. Disk sec/Transfer",
    unit = "sec",
    description = "Avg. Disk sec/Transfer")
  double getAverageDiskSecPerTransfer();

  @ManagedMetric(
    displayName = "Avg. Disk sec/Read",
    unit = "sec",
    description = "Avg. Disk sec/Read")
  double getAverageDiskSecondPerRead();

  @ManagedMetric(
    displayName = "Avg. Disk sec/Write",
    unit = "sec",
    description = "Avg. Disk sec/Write")
  double getAverageDiskSecondPerWrite();

  @ManagedMetric(
    displayName = "Disk Transfers/sec",
    unit = "transfer/sec",
    description = "Disk Transfers/sec")
  double getDiskTransfersPerSec();

  @ManagedMetric(
    displayName = "Disk Reads/sec",
    unit = "reads/sec",
    description = "Disk Reads/sec")
  double getDiskReadsPerSec();

  @ManagedMetric(
    displayName = "Disk Writes/sec",
    unit = "writes/sec",
    description = "Disk Writes/sec")
  double getDiskWritesPerSec();

  @ManagedMetric(
    displayName = "Disk Bytes/sec",
    unit = "bytes/sec",
    description = "Disk Bytes/sec")
  double getDiskBytesPerSec();

  @ManagedMetric(
    displayName = "Disk Read Bytes/sec",
    unit = "bytes/sec",
    description = "Disk Read Bytes/sec")
  double getDiskReadBytesPerSec();

  @ManagedMetric(
    displayName = "Disk Write Bytes/sec",
    unit = "bytes/sec",
    description = "Disk Write Bytes/sec")
  double getDiskWriteBytesPerSec();

  @ManagedMetric(
    displayName = "Avg. Disk Bytes/Transfer",
    unit = "bytes/transfer",
    description = "Avg. Disk Bytes/Transfer")
  double getAverageDiskBytesPerTransfer();

  @ManagedMetric(
    displayName = "Avg. Disk Bytes/Read",
    unit = "bytes/read",
    description = "Avg. Disk Bytes/Read")
  double getAverageDiskBytesPerRead();

  @ManagedMetric(
    displayName = "Avg. Disk Bytes/Write",
    unit = "bytes/write",
    description = "Avg. Disk Bytes/Write")
  double getAverageDiskBytesPerWrite();

  @ManagedMetric(
    displayName = "% Idle Time",
    unit = "%",
    description = "% Idle Time")
  double getPercentIdleTime();

  @ManagedMetric(
    displayName = "Split IO/sec",
    unit = "io/sec",
    description = "Split IO/Sec")
  double getSplitIOPerSec();

}
