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
    description = "The percentage of time the processor was busy servicing a specific process.")
  double getPercentProcessorTime();

  @ManagedMetric(
    displayName = "% User Time",
    unit = "%",
    description = "The percentage of time a process was running in user mode.")
  double getPercentUserTime();

  @ManagedMetric(
    displayName = "% Privileged Time",
    unit = "%",
    description = "The percentage of time a process was running in privileged mode.")
  double getPercentPrivilegedTime();

  @ManagedMetric(
    displayName = "Virtual Bytes Peak",
    unit = "bytes",
    description = "Virtual Bytes Peak is the maximum size, in bytes, of virtual address space the process " +
    "has used at any one time. Use of virtual address space does not necessarily imply corresponding use of " +
    "either disk or main memory pages. However, virtual space is finite, and the process might limit its ability to load libraries.")
  double getVirtualBytesPeak();

  @ManagedMetric(
    displayName = "Virtual Bytes",
    unit = "bytes",
    description = "Virtual Bytes is the current size, in bytes, of the virtual address space the process is " +
    "using. Use of virtual address space does not necessarily imply corresponding use of either disk or main " +
    "memory pages. Virtual space is finite, and the process can limit its ability to load libraries.")
  double getVirtualBytes();

  @ManagedMetric(
    displayName = "Page Faults/sec",
    unit = "faults/sec",
    description = "Shows the rate at which page faults by the threads executing in this process are occurring. " +
    "A page fault occurs when a thread refers to a virtual memory page that is not in its working set in main memory. " +
    "This does not cause the page to be fetched from disk if it is on the standby list and hence already in main memory, " +
    "or if it is in use by another process with whom the page is shared.")
  double getPageFaultsPerSec();

  @ManagedMetric(
    displayName = "Working Set Peak",
    unit = "bytes",
    description = "Shows the maximum size, in bytes, in the working set of this process at any point in time. " +
    "The working set is the set of memory pages touched recently by the threads in the process. If free memory " +
    "in the computer is above a certain threshold, pages are left in the working set of a process even if they " +
    "are not in use. When free memory falls below a certain threshold, pages are trimmed from working sets. If " +
    "they are needed, they are then soft-faulted back into the working set before they leave main memory.")
  double getWorkingSetPeak();

  @ManagedMetric(
    displayName = "Working Set",
    unit = "bytes",
    description = "Working Set is the current size, in bytes, of the Working Set of this process. The Working Set " +
    "is the set of memory pages touched recently by the threads in the process. If free memory in the computer is " +
    "above a threshold, pages are left in the Working Set of a process even if they are not in use. When free memory " +
    "falls below a threshold, pages are trimmed from Working Sets. If they are needed they will then be soft-faulted " +
    "back into the Working Set before leaving main memory.")
  double getWorkingSet();

  @ManagedMetric(
    displayName = "Page File Bytes Peak",
    unit = "bytes",
    description = "Shows the maximum number of bytes that this process has used in the paging file(s). Paging " +
    "files are used to store pages of memory used by the process that are not contained in other files. Paging " +
    "files are shared by all processes, and lack of space in paging files can prevent other processes from allocating memory.")
  double getPageFileBytesPeak();

  @ManagedMetric(
    displayName = "Page File Bytes",
    unit = "bytes",
    description = "Shows the current number of bytes that this process has used in the paging file(s). " +
    "Paging files are used to store pages of memory used by the process that are not contained in other files. " +
    "Paging files are shared by all processes, and lack of space in paging files can prevent other processes from allocating memory.")
  double getPageFileBytes();

  @ManagedMetric(
    displayName = "Private Bytes",
    unit = "bytes",
    description = "Private Bytes is the current size, in bytes, of memory that this process has allocated that cannot be shared with other processes.")
  double getPrivateBytes();

  @ManagedMetric(
    displayName = "Thread Count",
    unit = "bytes",
    description = "Shows the number of threads currently active in this process. An instruction is the basic " +
    "unit of execution in a processor, and a thread is the object that executes instructions. Every running process has at least one thread.")
  double getThreadCount();

  @ManagedMetric(
    displayName = "Priority Base",
    description = "Windows schedules threads of a process to run according to their priority. Threads inherit " +
    "base priority from their parent processes. The base priority level of the process can range from lowest to highest: Idle, Normal, High, or Real Time.")
  double getPriorityBase();

  @ManagedMetric(
    displayName = "Uptime",
    unit = "sec",
    description = "Total time since the process started.")
  double getElapsedTime();

  @ManagedMetric(
    displayName = "Process ID",
    description = "Shows the unique identifier of this process. ID Process numbers are reused, so they only identify a process for the lifetime of that process.")
  double getIDProcess();

  @ManagedMetric(
    displayName = "Creating Process ID",
    unit = "sec",
    description = "Shows the identifier of the process that created the current process. Note that the creating " +
    "process may have terminated since this process was created and so this value may no longer identify a running process.")
  double getCreatingProcessID();

  @ManagedMetric(
    displayName = "Pool Paged Bytes",
    unit = "bytes",
    description = "Shows the number of bytes in the Paged Pool, a system memory area where space is acquired by operating " +
    "system components as they accomplish their appointed tasks. Paged Pool pages can be paged out to the paging file when " +
    "not accessed by the system for sustained periods of time.")
  double getPoolPagedBytes();

  @ManagedMetric(
    displayName = "Pool Nonpaged Bytes",
    unit = "bytes",
    description = "Shows the number of bytes in the nonpaged pool, a system memory area where space is acquired by " +
    "operating system components as they accomplish their appointed tasks. Nonpaged pool pages cannot be paged out " +
    "to the paging file, but instead remain in main memory as long as they are allocated.")
  double getPoolNonpagedBytes();

  @ManagedMetric(
    displayName = "Handle Count",
    unit = "handles",
    description = "Shows the total number of handles currently open by this process. This number is the equal to " +
    "the sum of the handles currently open by each thread in this process.")
  double getHandleCount();

  @ManagedMetric(
    displayName = "IO Read Operations/sec",
    unit = "IO/sec",
    description = "Shows the rate at which the process is issuing read I/O operations. This counter counts all " +
    "I/O activity generated by the process to include file, network and device I/O's.")
  double getIOReadOperationsPerSec();

  @ManagedMetric(
    displayName = "IO Write Operations/sec",
    unit = "IO/sec",
    description = "Shows the rate at which the process is issuing write I/O operations. This counter counts all " +
    "I/O activity generated by the process to include file, network and device I/O's.")
  double getIOWriteOperationsPerSec();

  @ManagedMetric(
    displayName = "IO Data Operations/sec",
    unit = "IO/sec",
    description = "Shows the rate at which the process is issuing read and write I/O operations. This counter " +
    "counts all I/O activity generated by the process to include file, network and device I/O's.")
  double getIODataOperationsPerSec();

  @ManagedMetric(
    displayName = "IO Other Operations/sec",
    unit = "IO/sec",
    description = "Shows the rate at which the process is issuing I/O operations that are neither a read or " +
    "a write operation. An example of this type of operation would be a control function. This counter counts " +
    "all I/O activity generated by the process to include file, network and device I/O's.")
  double getIOOtherOperationsPerSec();

  @ManagedMetric(
    displayName = "IO Read Bytes/sec",
    unit = "bytes/sec",
    description = "Shows the rate at which the process is reading bytes from I/O operations. This counter " +
    "counts all I/O activity generated by the process to include file, network and device I/O's.")
  double getIOReadBytesPerSec();

  @ManagedMetric(
    displayName = "IO Write Bytes/sec",
    unit = "bytes/sec",
    description = "Shows the rate the process is writing bytes to I/O operations. This counter counts all " +
    "I/O activity generated by the process to include file, network and device I/O's.")
  double getIOWriteBytesPerSec();

  @ManagedMetric(
    displayName = "IO Data Bytes/sec",
    unit = "bytes/sec",
    description = "Shows the rate at which the process is reading and writing bytes in I/O operations. " +
    "This counter counts all I/O activity generated by the process to include file, network and device I/O's.")
  double getIODataBytesPerSec();

  @ManagedMetric(
    displayName = "IO Other Bytes/sec",
    unit = "bytes/sec",
    description = "Shows the rate at which the process is issuing bytes to I/O operations that don't " +
    "involve data such as control operations. This counter counts all I/O activity generated by the process to include file, network and device I/O's.")
  double getIOOtherBytesPerSec();

  @ManagedMetric(
    displayName = "Working Set - Private",
    description = "Working Set - Private displays the size of the working set, in bytes, that is use for " +
    "this process only and not shared nor sharable by other processes.")
  double getWorkingSetPrivate();
}
