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
    description = "This is an “estimated” average number of requests that are either in process or waiting " +
    "to be processed by the Disk. This is an instantaneous counter. Observe its value over several intervals or use Avg. Disk Queue Length.")
  double getCurrentDiskQueueLength();

  @ManagedMetric(
    displayName = "% Disk Time",
    unit = "%",
    description = "Percentage of time during which the disk was busy. The “% Disk Time” counter is nothing more " +
    "than the “Avg. Disk Queue Length” counter multiplied by 100. It is the same value displayed in a different scale.")
  double getPercentDiskTime();

  @ManagedMetric(
    displayName = "Avg. Disk Queue Length",
    unit = "length",
    description = "The Avg. Disk Queue Length counter is the “estimated” average number of requests that are either " +
    "in process or waiting to be processed by the Disk. It is equal to the (Disk Transfers/sec) * (Disk sec/Transfer).")
  double getAverageDiskQueueLength();

  @ManagedMetric(
    displayName = "% Disk Read Time",
    unit = "length",
    description = "The Disk Read Bytes/sec shows the Disk Throughput of the Read Operation of the Disk.")
  double getPercentDiskReadTime();

  @ManagedMetric(
    displayName = "Avg. Disk Read Queue Length",
    unit = "length",
    description = "Estimated number of read requests that are either in process or waiting to be processed by the Disk.")
  double getAverageDiskReadQueueLength();

  @ManagedMetric(
    displayName = "% Disk Write Time",
    unit = "%",
    description = "The Disk Write Bytes/sec shows the Disk Throughput of the Write Operation of the Disk.")
  double getPercentDiskWriteTime();

  @ManagedMetric(
    displayName = "Avg. Disk Write Queue Length",
    unit = "length",
    description = "Estimated number of write requests that are either in process or waiting to be processed by the Disk.")
  double getAverageDiskWriteQueueLength();

  @ManagedMetric(
    displayName = "Avg. Disk sec/Transfer",
    unit = "sec",
    description = "The Avg. Disk sec/Write displays how long in milliseconds it takes for a transfer operation to the Disk.")
  double getAverageDiskSecPerTransfer();

  @ManagedMetric(
    displayName = "Avg. Disk sec/Read",
    unit = "sec",
    description = "The Avg. Disk sec/Read displays how long in milliseconds it takes for a read operation from the Disk.")
  double getAverageDiskSecondPerRead();

  @ManagedMetric(
    displayName = "Avg. Disk sec/Write",
    unit = "sec",
    description = "The Avg. Disk sec/Write displays how long in milliseconds it takes for a write operation to the Disk.")
  double getAverageDiskSecondPerWrite();

  @ManagedMetric(
    displayName = "Disk Transfers/sec",
    unit = "transfer/sec",
    description = "Number of transfers per second.")
  double getDiskTransfersPerSec();

  @ManagedMetric(
    displayName = "Disk Reads/sec",
    unit = "reads/sec",
    description = "Number of reads per second.")
  double getDiskReadsPerSec();

  @ManagedMetric(
    displayName = "Disk Writes/sec",
    unit = "writes/sec",
    description = "Number of writes per second.")
  double getDiskWritesPerSec();

  @ManagedMetric(
    displayName = "Disk Bytes/sec",
    unit = "bytes/sec",
    description = "Rate of transfer for all requests.")
  double getDiskBytesPerSec();

  @ManagedMetric(
    displayName = "Disk Read Bytes/sec",
    unit = "bytes/sec",
    description = "Rate of transfer for read requests.")
  double getDiskReadBytesPerSec();

  @ManagedMetric(
    displayName = "Disk Write Bytes/sec",
    unit = "bytes/sec",
    description = "Rate of transfer for read requests.")
  double getDiskWriteBytesPerSec();

  @ManagedMetric(
    displayName = "Avg. Disk Bytes/Transfer",
    unit = "bytes/transfer",
    description = "Average size of transfer requests.")
  double getAverageDiskBytesPerTransfer();

  @ManagedMetric(
    displayName = "Avg. Disk Bytes/Read",
    unit = "bytes/read",
    description = "Average size of read requests.")
  double getAverageDiskBytesPerRead();

  @ManagedMetric(
    displayName = "Avg. Disk Bytes/Write",
    unit = "bytes/write",
    description = "Average size of write requests.")
  double getAverageDiskBytesPerWrite();

  @ManagedMetric(
    displayName = "% Idle Time",
    unit = "%",
    description = "This counter provides a very precise measurement of how much time the disk remained in idle " +
    "state, meaning all the requests from the operating system to the disk have been completed and there is zero pending requests.")
  double getPercentIdleTime();

  @ManagedMetric(
    displayName = "Split IO/sec",
    unit = "io/sec",
    description = "The Split IO/sec counter displays the physical disk requests that are split into " +
    "multiple requests. This counter is a primary indicator if a disk is fragmented and needs to be optimized.")
  double getSplitIOPerSec();

}
