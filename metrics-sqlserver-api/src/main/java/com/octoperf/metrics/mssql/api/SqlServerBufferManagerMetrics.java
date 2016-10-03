package com.octoperf.metrics.mssql.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "SQLServer:type=BufferManager",
  description = "The Buffer Manager object provides counters to monitor how SQL Server uses: " +
    "Memory to store data pages. " +
    "Counters to monitor the physical I/O as SQL Server reads and writes database pages. " +
    "Buffer pool extension to extend the buffer cache by using fast non-volatile storage such as solid-state drives (SSD).")
public interface SqlServerBufferManagerMetrics {

  @ManagedMetric(
    displayName = "Free List Stalls/sec",
    unit = "stalls/sec",
    description = "Indicates the number of requests per second that had to wait for a free page.")
  double getFreeListStallsPerSec();

  @ManagedMetric(
    displayName = "Lazy Writes/Sec",
    unit = "writes/sec",
    description = "Monitors the number of times per second that " +
      "the Lazy Writer process moves dirty pages from " +
      "the buffer to disk as it frees up buffer space. " +
      "Lower is better with zero being ideal. When " +
      "greater than 20, this counter indicates a need for " +
      "more memory.")
  double getLazyWritesPerSec();

  @ManagedMetric(
    displayName = "Checkpoint Pages/Sec",
    unit = "pages/sec",
    description = "Monitors the number of dirty pages, per second, " +
      "that are flushed to disk when SQL Server invokes " +
      "the checkpoint process. Checkpoint frequency " +
      "is influenced by the recovery interval setting in " +
      "sp_configure. High values for this counter may " +
      "indicate insufficient memory or that the " +
      "recovery interval is too high. ")
  double getCheckpointPagesPerSec();

  @ManagedMetric(
    displayName = "Page Life Expectancy",
    unit = "sec",
    description = "Tells, on average, how many seconds SQL Server " +
      "expects a data page to stay in cache. The target " +
      "on an OLTP system should be at least 300 (5 " +
      "min). When under 300, this may indicate poor " +
      "index design (leading to increased disk I/O " +
      "and less effective use of memory) or, simply, a " +
      "potential shortage of memory.")
  double getPageLifeExpectancy();

  @ManagedMetric(
    displayName = "Page Lookups/sec",
    unit = "lookups/sec",
    description = "The number of requests to find a page in the " +
      "buffer pool. When the ratio of batch requests " +
      "to page lookups crests 100, you may have " +
      "inefficient execution plans or too many adhoc " +
      "queries. ")
  double getPageLookupsPerSec();

  @ManagedMetric(
    displayName = "Page Reads/sec",
    unit = "reads/sec",
    description = "Number of physical database page reads issued " +
      "per second. Normal OLTP workloads support " +
      "80 - 90 per second, but higher values may be " +
      "a yellow flag for poor indexing or insufficient " +
      "memory.")
  double getPageReadsPerSec();

  @ManagedMetric(
    displayName = "Page Writes/sec",
    unit = "writes/sec",
    description = "Number of database pages physically written " +
      "to disk per second. Normal OLTP workloads " +
      "support 80 - 90 per second. Values over 90 " +
      "should be crossed checked with 'lazy writer/sec' " +
      "and “checkpoint” counters. If the other counters " +
      "are also high, then it may indicate insufficient " +
      "memory.")
  double getPageWritesPerSec();

  @ManagedMetric(
    displayName = "Readahead/sec",
    unit = "readahead/sec",
    description = "Number of data pages read per second in " +
      "anticipation of their use. If this value is makes up " +
      "even a sizeable minority of total Page Reads/sec " +
      "(say, greater than 20% of total page reads), you " +
      "may have too many physical reads occurring.")
  double getReadaheadPerSec();


  @ManagedMetric(
    displayName = "Database Pages",
    unit = "pages",
    description = "Number of database pages in the buffer pool, " +
      "as opposed to other usages for memory such " +
      "as free pages, procedure cache, etc.")
  double getDatabasePages();

  @ManagedMetric(
    displayName = "Target Pages",
    unit = "pages",
    description = "The ideal number of pages in the buffer pool " +
      "according the maximum memory granted to " +
      "SQL Server in sp_configure.")
  double getTargetPages();

  @ManagedMetric(
    displayName = "Buffer Cache Hit Ratio",
    unit = "%",
    description = "Long a stalwart counter used by SQL Server DBAs, this counter is no longer very useful. " +
      "It monitors the percentage of data requests answer from the buffer cache since the last" +
      "reboot.")
  double getBufferCacheHitRatio();
}
