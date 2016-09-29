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
    description = "")
  double getPagesOutputPerSec();

  @ManagedMetric(
    displayName = "Page Writes/sec",
    unit = "writes/sec",
    description = "Page Writes/sec is the rate at which pages are written to disk " +
    "to free up space in physical memory. Pages are written to disk only if they are changed " +
    "while in physical memory, so they are likely to hold data, not code. ")
  double getPageWritesPerSec();

  @ManagedMetric(
    displayName = "Pool Paged Allocations",
    unit = "allocs",
    description = "Pool Paged Allocations.")
  double getPoolPagedAllocs();

  @ManagedMetric(
    displayName = "Pool Non Paged Allocs",
    unit = "allocs",
    description = "The nonpaged pool is an area of system memory for objects that can’t be written to disk.")
  double getPoolNonPagedAllocs();

  @ManagedMetric(
    displayName = "Cache Bytes",
    unit = "Bytes",
    description = "Cache bytes.")
  double getCacheBytes();

  @ManagedMetric(
    displayName = "Peak Cache Bytes",
    unit = "Bytes",
    description = "Peak Cache bytes.")
  double getCacheBytesPeak();

  @ManagedMetric(
    displayName = "Pool Paged Resident Bytes",
    unit = "Bytes",
    description = "Pool Paged Resident Bytes.")
  double getPoolPagedResidentBytes();

  @ManagedMetric(
    displayName = "System Code Total Bytes",
    unit = "Bytes",
    description = "System Code Total Bytes.")
  double getSystemCodeTotalBytes();

  @ManagedMetric(
    displayName = "System Code Resident Bytes",
    unit = "Bytes",
    description = "System Code Resident Bytes.")
  double getSystemCodeResidentBytes();

  @ManagedMetric(
    displayName = "System Driver Total Bytes",
    unit = "Bytes",
    description = "System Driver Total Bytes.")
  double getSystemDriverTotalBytes();

  @ManagedMetric(
    displayName = "System Driver Resident Bytes",
    unit = "Bytes",
    description = "System Driver Resident Bytes.")
  double getSystemDriverResidentBytes();

  @ManagedMetric(
    displayName = "System Cache Resident Bytes",
    unit = "Bytes",
    description = "System Cache Resident Bytes.")
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
    "to disk when they are not being used. Paged Pool is a larger resource than Nonpaged pool – " +
    "however, if this value is consistently greater than 70% of the maximum configured pool size, " +
    "you may be at risk of a Paged Pool depletion (Event ID 2020). ")
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
    description = "Page Faults per second.")
  double getPageFaultsPerSec();

  @ManagedMetric(
    displayName = "Commit Limit",
    unit = "Bytes",
    description = "Commit Limit.")
  double getCommitLimit();

  @ManagedMetric(
    displayName = "Write copies/sec",
    unit = "copies/sec",
    description = "Writes copies per second.")
  double getWriteCopiesPerSec();

  @ManagedMetric(
    displayName = "Cache Faults/sec",
    unit = "faults/sec",
    description = "Cache Faults per second.")
  double getCacheFaultsPerSec();
}
