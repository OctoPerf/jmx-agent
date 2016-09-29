package com.octoperf.metrics.windows.pdh.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

import static org.springframework.jmx.support.MetricType.COUNTER;

@ManagedResource("Windows:type=System")
public interface WindowsSystemMetrics {

  @ManagedMetric(description = "Processor count.")
  double getProcessorCount();

  @ManagedMetric(
    unit = "length",
    displayName="Processor Queue Length")
  double getProcessorQueueLength();

  @ManagedMetric(
    unit = "length/cpu",
    displayName="Processor Queue Length Per CPU")
  double getProcessorQueueLengthPerCPU();

  @ManagedMetric(
    displayName = "Context Switches/sec",
    unit = "length",
    description="The average rate per second at which context switches " +
    "among threads on the computer.")
  double getContextSwitchesPerSec();

  @ManagedMetric(displayName="File Read Operations/sec", unit = "ops/sec")
  double getFileReadOperationsPerSec();

  @ManagedMetric(displayName="File Write Operations/sec", unit = "ops/sec")
  double getFileWriteOperationsPerSec();

  @ManagedMetric(displayName="File Control Operations/sec", unit = "ops/sec")
  double getFileControlOperationsPerSec();

  @ManagedMetric(displayName="File Read Bytes/sec", unit = "ops/sec")
  double getFileReadBytesPerSec();

  @ManagedMetric(displayName="File Control Bytes/sec", unit = "ops/sec")
  double getFileControlBytesPerSec();

  @ManagedMetric(displayName="System Calls/sec", unit = "ops/sec")
  double getSystemCallsPerSec();

  @ManagedMetric(displayName="File Data Operations/sec", unit = "ops/sec")
  double getFileDataOperationsPerSec();

  @ManagedMetric(metricType = COUNTER, displayName="System Uptime", unit = "sec")
  double getSystemUpTime();

  @ManagedMetric(displayName="Processes", unit = "processes")
  double getProcesses();

  @ManagedMetric(displayName="Threads", unit = "threads")
  double getThreads();

  @ManagedMetric(displayName="Alignment Fixups/sec", unit = "fixups/sec")
  double getAlignmentFixupsPerSec();

  @ManagedMetric(displayName="Exception Dispatches/sec", unit="exceptions/sec")
  double getExceptionDispatchesPerSec();

  @ManagedMetric(displayName="Floating Emulations/sec", unit="emu/sec")
  double getFloatingEmulationsPerSec();

  @ManagedMetric(displayName="% Registry Quote In Use", unit="%")
  double getPercentRegistryQuotaInUse();
}
