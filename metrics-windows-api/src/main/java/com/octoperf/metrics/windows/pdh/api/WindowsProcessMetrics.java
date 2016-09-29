package com.octoperf.metrics.windows.pdh.api;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public interface WindowsProcessMetrics {

  @ManagedAttribute(description = "Process name.")
  String getInstance();

  @ManagedMetric(
    displayName = "% Processor Time",
    unit = "%",
    description = "% Processor Time")
  double getPercentProcessorTime();

  @ManagedMetric(
    displayName = "% User Time",
    unit = "%",
    description = "% User Time")
  double getPercentUserTime();

  @ManagedMetric(
    displayName = "% Privileged Time",
    unit = "%",
    description = "% Privileged Time")
  double getPercentPrivilegedTime();

  @ManagedMetric(
    displayName = "Virtual Bytes Peak",
    unit = "bytes",
    description = "Virtual Bytes Peak")
  double getVirtualBytesPeak();

  @ManagedMetric(
    displayName = "Virtual Bytes",
    unit = "bytes",
    description = "Virtual Bytes")
  double getVirtualBytes();

  @ManagedMetric(
    displayName = "Page Faults/sec",
    unit = "faults/sec",
    description = "Page Faults/sec")
  double getPageFaultsPerSec();

  @ManagedMetric(
    displayName = "Working Set Peak",
    unit = "bytes",
    description = "Working Set Peak")
  double getWorkingSetPeak();

  @ManagedMetric(
    displayName = "Working Set",
    unit = "bytes",
    description = "Working Set")
  double getWorkingSet();

  @ManagedMetric(
    displayName = "Page File Bytes Peak",
    unit = "bytes",
    description = "Page File Bytes Peak")
  double getPageFileBytesPeak();

  @ManagedMetric(
    displayName = "Page File Bytes",
    unit = "bytes",
    description = "Page File Bytes")
  double getPageFileBytes();

  @ManagedMetric(
    displayName = "Private Bytes",
    unit = "bytes",
    description = "Private Bytes")
  double getPrivateBytes();

  @ManagedMetric(
    displayName = "Thread Count",
    unit = "bytes",
    description = "Thread Count")
  double getThreadCount();

  @ManagedMetric(
    displayName = "Priority Base",
    description = "Priority Base")
  double getPriorityBase();

  @ManagedMetric(
    displayName = "Uptime",
    unit = "sec",
    description = "System Uptime in seconds.")
  double getElapsedTime();

  @ManagedMetric(
    displayName = "Process ID",
    description = "ID Process")
  double getIDProcess();

  @ManagedMetric(
    displayName = "Creating Process ID",
    unit = "sec",
    description = "Creating Process ID")
  double getCreatingProcessID();

  @ManagedMetric(
    displayName = "Pool Paged Bytes",
    unit = "bytes",
    description = "Pool Paged Bytes")
  double getPoolPagedBytes();

  @ManagedMetric(
    displayName = "Pool Nonpaged Bytes",
    unit = "bytes",
    description = "Pool Nonpaged Bytes")
  double getPoolNonpagedBytes();

  @ManagedMetric(
    displayName = "Handle Count",
    unit = "handles",
    description = "Handle Count")
  double getHandleCount();

  @ManagedMetric(
    displayName = "IO Read Operations/sec",
    unit = "IO/sec",
    description = "IO Read Operations/sec")
  double getIOReadOperationsPerSec();

  @ManagedMetric(
    displayName = "IO Write Operations/sec",
    unit = "IO/sec",
    description = "IO Write Operations/sec")
  double getIOWriteOperationsPerSec();

  @ManagedMetric(
    displayName = "IO Data Operations/sec",
    unit = "IO/sec",
    description = "IO Data Operations/sec")
  double getIODataOperationsPerSec();

  @ManagedMetric(
    displayName = "IO Other Operations/sec",
    unit = "IO/sec",
    description = "IO Other Operations/sec")
  double getIOOtherOperationsPerSec();

  @ManagedMetric(
    displayName = "IO Read Bytes/sec",
    unit = "bytes/sec",
    description = "IO Read Bytes/sec")
  double getIOReadBytesPerSec();

  @ManagedMetric(
    displayName = "IO Write Bytes/sec",
    unit = "bytes/sec",
    description = "IO Write Bytes/sec")
  double getIOWriteBytesPerSec();

  @ManagedMetric(
    displayName = "IO Data Bytes/sec",
    unit = "bytes/sec",
    description = "IO Data Bytes/sec")
  double getIODataBytesPerSec();

  @ManagedMetric(
    displayName = "IO Other Bytes/sec",
    unit = "bytes/sec",
    description = "IO Other Bytes/sec")
  double getIOOtherBytesPerSec();

  @ManagedMetric(
    displayName = "Working Set - Private",
    description = "Working Set - Private")
  double getWorkingSetPrivate();
}
