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
    displayName="Processor Queue Length",
    description = "Shows the number of threads in the processor queue. There is a single queue for processor time even on computers with multiple processors. Therefore, you may need to divide this value by the number of processors servicing the workload. Unlike the disk counters, this counter shows ready threads only, not threads that are running. A sustained processor queue of greater than two threads generally indicates processor congestion.")
  double getProcessorQueueLength();

  @ManagedMetric(
    unit = "length/cpu",
    displayName="Processor Queue Length Per CPU",
    description = "Shows the number of threads in the processor queue per processor. Unlike the disk counters, this counter shows ready threads only, not threads that are running. A sustained processor queue of greater than two threads generally indicates processor congestion.")
  double getProcessorQueueLengthPerCPU();

  @ManagedMetric(
    displayName = "Context Switches/sec",
    unit = "length",
    description="Shows the combined rate at which all processors on the computer are switched from one thread to another. Context switches occur when a running thread voluntarily relinquishes the processor, is preempted by a higher priority, ready thread, or switches between user-mode and privileged (kernel) mode to use an Executive or subsystem service. It is the sum of the values of Thread\\Thread: Context Switches/sec for each thread running on all processors on the computer and is measured in numbers of switches. There are context switch counters on the System and Thread objects.")
  double getContextSwitchesPerSec();

  @ManagedMetric(displayName="File Read Operations/sec", unit = "ops/sec",
  description = "Shows the combined rate of file system read requests to all devices on the computer, including requests to read from the file system cache. It is measured in numbers of read operations per second.")
  double getFileReadOperationsPerSec();

  @ManagedMetric(displayName="File Write Operations/sec", unit = "ops/sec",
  description = "Shows the combined rate of file system write requests to all devices on the computer, including requests to write to data in the file system cache. It is measured in numbers of write operations per second.")
  double getFileWriteOperationsPerSec();

  @ManagedMetric(displayName="File Control Operations/sec", unit = "ops/sec",
  description = "Shows the combined rate of file system operations that are neither read nor write operations, such as file system control requests and requests for information about device characteristics or status. This is the inverse of System\\System: File Data Operations/sec and is measured in numbers of operations.")
  double getFileControlOperationsPerSec();

    @ManagedMetric(displayName="File Read Bytes/sec", unit = "ops/sec",
    description = "Shows the overall rate at which bytes are read to satisfy file system read requests to all devices on the computer, including read operations from the file system cache. It is measured in numbers of bytes per second.")
    double getFileReadBytesPerSec();

    @ManagedMetric(displayName="File Write Bytes/sec", unit = "ops/sec",
    description = "Shows the overall rate at which bytes are written to satisfy file system write requests to all devices on the computer, including write operations to the file system cache. It is measured in numbers of bytes per second.")
    double getFileWriteBytesPerSec();

  @ManagedMetric(displayName="File Control Bytes/sec", unit = "ops/sec",
  description = "File Control Bytes/sec shows the overall rate at which bytes are transferred for all file system operations that are neither read nor write operations, including file system control requests and requests for information about device characteristics or status. It is measured in numbers of bytes per second.")
  double getFileControlBytesPerSec();

  @ManagedMetric(displayName="System Calls/sec", unit = "ops/sec",
  description = "Shows the combined rate of calls to Windows system service routines by all processes running on the computer. These routines perform all of the basic scheduling and synchronization of activities on the computer, and provide access to nongraphic devices, memory management, and name space management.")
  double getSystemCallsPerSec();

  @ManagedMetric(displayName="File Data Operations/sec", unit = "ops/sec",
  description = "Shows the combined rate of read and write operations on all logical disks on the computer. This is the inverse of System\\System: File Control Operations/sec.")
  double getFileDataOperationsPerSec();

  @ManagedMetric(metricType = COUNTER, displayName="System Uptime", unit = "sec",
  description = "Total time since last startup.")
  double getSystemUpTime();

  @ManagedMetric(displayName="Processes", unit = "processes",
  description = "Total number of processes running.")
  double getProcesses();

  @ManagedMetric(displayName="Threads", unit = "threads",
  description = "Total number of threads running.")
  double getThreads();

  @ManagedMetric(displayName="Alignment Fixups/sec", unit = "fixups/sec",
  description = "Shows the rate of alignment faults fixed by the system.")
  double getAlignmentFixupsPerSec();

  @ManagedMetric(displayName="Exception Dispatches/sec", unit="exceptions/sec",
  description = "Shows the rate at which exceptions are dispatched by the system.")
  double getExceptionDispatchesPerSec();

  @ManagedMetric(displayName="Floating Emulations/sec", unit="emu/sec",
  description = "Shows the rate of floating emulations performed by the system.")
  double getFloatingEmulationsPerSec();

  @ManagedMetric(displayName="% Registry Quota In Use", unit="%",
  description = "Shows the percentage of the Total Registry Quota Allowed that is currently being used by the system.")
  double getPercentRegistryQuotaInUse();
}
