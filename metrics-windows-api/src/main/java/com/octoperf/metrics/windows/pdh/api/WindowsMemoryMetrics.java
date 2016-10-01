package com.octoperf.metrics.windows.pdh.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource("Windows:type=Memory")
public interface WindowsMemoryMetrics {

  @ManagedMetric(
      displayName = "Available MBytes",
      unit = "MB",
      description="This measures the amount of physical memory, in megabytes, " +
    "available for running processes. If this value is less than 5 percent of the total physical RAM " +
    ", that means there is insufficient memory, and that can increase paging activity. " +
    "To resolve this problem, you should simply add more memory.")
  double getAvailableMBytes();

  @ManagedMetric(
      displayName = "% Commited Bytes In Use",
      unit = "%",
    description = "This measures the ratio of Committed Bytes to the Commit " +
    "Limit - in other words, the amount of virtual memory in use.")
  double getPercentCommittedBytesInUse();

  @ManagedMetric(
      displayName = "Demande Zero Faults/sec",
      unit = "faults/sec",
      description = "Demand Zero Faults per second.")
  double getDemandZeroFaultsPerSec();

  @ManagedMetric(
    displayName = "Pages Input/sec",
    unit = "input/sec",
    description = "Pages Input/sec is the total number of pages read from disk to resolve hard page faults.")
  double getPagesInputPerSec();

  @ManagedMetric(
    displayName = "Page Reads/sec",
    unit = "reads/sec",
    description = "Page Reads/sec is the rate at which the disk was read to resolve " +
    "hard page faults. It shows the number of reads operations, without regard to the number of " +
    "pages retrieved in each operation.")
  double getPageReadsPerSec();

  @ManagedMetric(
    displayName = "Pages Output/sec",
    unit = "output/sec",
    description = "Shows the rate at which pages are written to disk to free up space " +
    "in physical memory. A high rate of pages output might indicate a memory shortage. "+
    "This counter shows numbers of pages, and can be compared to other counts of pages without conversion")
  double getPagesOutputPerSec();

  @ManagedMetric(
    displayName = "Page Writes/sec",
    unit = "writes/sec",
    description = "Page Writes/sec is the rate at which pages are written to disk " +
    "to free up space in physical memory. Pages are written to disk only if they are changed " +
    "while in physical memory, so they are likely to hold data, not code.")
  double getPageWritesPerSec();

  @ManagedMetric(
    displayName = "Pool Paged Allocations",
    unit = "allocs",
    description = "Shows the number of calls to allocate space in the paged pool. " +
    "It is measured in numbers of calls to allocate space, regardless of the amount of space allocated in each call.")
  double getPoolPagedAllocs();

  @ManagedMetric(
    displayName = "Pool Non Paged Allocs",
    unit = "allocs",
    description = "The nonpaged pool is an area of system memory for objects that can’t be written to disk.")
  double getPoolNonPagedAllocs();

  @ManagedMetric(
    displayName = "Cache Bytes",
    unit = "Bytes",
    description = "This value includes not only the size of the cache but also the size of the paged pool " +
    "and the amount of pageable driver and kernel code. Essentially, these values measure the systems working set.")
  double getCacheBytes();

  @ManagedMetric(
    displayName = "Peak Cache Bytes",
    unit = "Bytes",
    description = "Shows the maximum number of bytes used by the file system cache since the system was last restarted. " +
    "This might be larger than the current size of the cache.")
  double getCacheBytesPeak();

  @ManagedMetric(
    displayName = "Pool Paged Resident Bytes",
    unit = "Bytes",
    description = "Shows the current size, in bytes, of the paged pool. Space used by the paged and nonpaged pools is " +
    "taken from physical memory, so a pool that is too large denies memory space to processes.")
  double getPoolPagedResidentBytes();

  @ManagedMetric(
    displayName = "System Code Total Bytes",
    unit = "Bytes",
    description = "This measures the size, in bytes, of pageable operating system code currently in virtual memory. " +
    "It is a measure of the amount of physical memory being used by the operating system that can be written to disk " +
    "when not in use. This value is calculated by adding the bytes in Ntoskrnl.exe, Hal.dll, the boot drivers, and file" +
    " systems loaded by Ntldr/osloader. This counter does not include code that must remain in physical memory and cannot be written to disk.")
  double getSystemCodeTotalBytes();

  @ManagedMetric(
    displayName = "System Code Resident Bytes",
    unit = "Bytes",
    description = "Shows the size, in bytes, of operating system code currently in physical memory that can be written " +
    "to disk when not in use. This value is a component of Memory\\ System Code Total Bytes, which also includes " +
    "operating system code on disk. Memory\\ System Code Resident Bytes (and Memory\\ System Code Total Bytes) does not " +
    "include code that must remain in physical memory and cannot be written to disk.")
  double getSystemCodeResidentBytes();

  @ManagedMetric(
    displayName = "System Driver Total Bytes",
    unit = "Bytes",
    description = "Displays the size, in bytes, of pageable virtual memory currently being used by device drivers. " +
    "Pageable memory can be written to disk when it is not being used. It includes physical memory (Memory\\ System " +
    "Driver Resident Bytes) and code and data written to disk. It is a component of Memory\\ System Code Total Bytes.")
  double getSystemDriverTotalBytes();

  @ManagedMetric(
    displayName = "System Driver Resident Bytes",
    unit = "Bytes",
    description = "Shows the size, in bytes, of pageable physical memory being used by device drivers. It is the " +
    "working set (physical memory area) of the drivers. This value is a component of Memory\\ System Driver Total " +
    "Bytes, which also includes driver memory that has been written to disk. Neither Memory\\ System Driver Resident " +
    "Bytes nor Memory\\ System Driver Total Bytes includes memory that cannot be written to disk.")
  double getSystemDriverResidentBytes();

  @ManagedMetric(
    displayName = "System Cache Resident Bytes",
    unit = "Bytes",
    description = "This shows the size, in bytes, of pageable operating system code in the file system cache. " +
    "This value includes only current physical pages and does not include any virtual memory pages not currently " +
    "resident. It does not equal the System Cache value shown in Task Manager. As a result, this value may be " +
    "smaller than the actual amount of virtual memory in use by the file system cache. This value is a component " +
    "of Memory\\ System Code Resident Bytes which represents all pageable operating system code that is currently in physical memory.")
  double getSystemCacheResidentBytes();

  @ManagedMetric(
    displayName = "Free System Page Table Entries",
    unit = "entries",
    description = "This indicates the number of page table entries not currently " +
    "in use by the system. If the number is less than 5,000, there may well be a memory leak.")
  double getFreeSystemPageTableEntries();

  @ManagedMetric(
    displayName = "Pool Non Paged Bytes",
    unit = "Bytes",
    description = "This measures the size, in bytes, of the non-paged pool. " +
    "This is an area of system memory for objects that cannot be written to disk but instead must " +
    "remain in physical memory as long as they are allocated.")
  double getPoolNonPagedBytes();

  @ManagedMetric(
    displayName = "Pool Paged Bytes",
    unit = "Bytes",
    description = "Pool Paged Bytes is the size, in bytes, of the paged pool, an " +
    "area of system memory (physical memory used by the operating system) for objects that can be written " +
    "to disk when they are not being used. Paged Pool is a larger resource than Nonpaged pool - " +
    "however, if this value is consistently greater than 70% of the maximum configured pool size, " +
    "you may be at risk of a Paged Pool depletion (Event ID 2020).")
  double getPoolPagedBytes();

  @ManagedMetric(
    displayName = "Pages/sec",
    unit = "pages/sec",
    description = "This measures the rate at which pages are read from or written " +
    "to disk to resolve hard page faults. If the value is greater than 1,000, as a result of excessive " +
    "paging, there may be a memory leak.")
  double getPagesPerSec();

  @ManagedMetric(
    displayName = "Page Faults/sec",
    unit = "faults/sec",
    description = "Shows the average number of pages faulted per second. It is measured in numbers of " +
    "pages faulted; because only one page is faulted in each fault operation, this is also equal to the " +
    "number of page fault operations. This counter includes both hard faults (those that require disk " +
    "access) and soft faults (where the faulted page is found elsewhere in physical memory). Most processors " +
    "can handle large numbers of soft faults without significant consequence. However, hard faults, which require disk access, can cause delays.")
  double getPageFaultsPerSec();

  @ManagedMetric(
    displayName = "Commit Limit",
    unit = "Bytes",
    description = "Commit limit is the amount of virtual memory, in bytes, that can be committed without " +
    "having to extend the paging file(s). Committed memory is physical memory which has space reserved on " +
    "the disk paging files. There can be one or more paging files on each physical drive. If the paging file(s) are expanded, this limit increases accordingly.")
  double getCommitLimit();

  @ManagedMetric(
    displayName = "Write copies/sec",
    unit = "copies/sec",
    description = "Shows the rate at which page faults are caused by attempts to write that have been satisfied " +
    "by copying the page from elsewhere in physical memory. This is an economical way of sharing data since pages " +
    "are only copied when they are written to; otherwise, the page is shared. This counter shows the number of copies, " +
    "without regard to the number of pages copied in each operation.")
  double getWriteCopiesPerSec();

  @ManagedMetric(
    displayName = "Cache Faults/sec",
    unit = "faults/sec",
    description = "This is the rate at which pages sought in the cache were not found there and had to be obtained elsewhere in memory or on the disk.")
  double getCacheFaultsPerSec();
}
