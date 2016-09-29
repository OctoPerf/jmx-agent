package com.octoperf.metrics.mssql.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "SQLServer:type=AccessMethods",
  description = "Searches through and measures allocation of SQL Server " +
    " database objects (for example, the number of index searches or number of pages that " +
    "are allocated to indexes and data).")
public interface SqlServerAccessMethodsMetrics {

  @ManagedMetric(
    displayName = "Forwarded Records/sec",
    unit = "records/sec",
    description = "Identifies use of a pointer which has been " +
      "created when variable length columns have " +
      "caused a row to move to a new page in a heap.")
  double getForwardedRecordsPerSec();

  @ManagedMetric(
    displayName = "Full Scans/sec",
    unit = "full scans/sec",
    description = "Monitors the number of full scans on tables " +
      "or indexes. Ignore unless high CPU coincides " +
      "with high scan rates. High scan rates may be " +
      "caused by missing indexes, very small tables, " +
      "or requests for too many records. A sudden " +
      "increase in this value may indicate a statistics " +
      "threshold has been reached, resulting in an " +
      "index no longer being used.")
  double getFullScansPerSec();

  @ManagedMetric(
    displayName = "Index Searches/sec",
    unit = "searches/sec",
    description = "Monitors the number of index searches " +
      "when doing range scans, single index record " +
      "fetches, and repositioning within an index. The " +
      "threshold recommendation is strictly for OLTP " +
      "workloads.")
  double getIndexSearchesPerSec();

  @ManagedMetric(
    displayName = "Page Splits/sec",
    unit = "splits/sec",
    description = "Monitors the number of page splits per second " +
      "which occur due to overflowing index pages " +
      "and should be as low as possible. To avoid " +
      "page splits, review table and index design to " +
      "reduce non-sequential inserts or implement " +
      "fillfactor and pad_index to leave more empty " +
      "space per page. ")
  double getPageSplitsPerSec();

  @ManagedMetric(
    displayName = "Workfiles Created/sec",
    unit = "splits/sec",
    description = "Number of work files created per second, " +
      "usually as a part of tempdb processing when " +
      "working with hashing joins and other hashing " +
      "operations. High values can indicate thrash in " +
      "tempdb and poorly coded queries.")
  double getWorkfilesCreatedPerSec();

  @ManagedMetric(
    displayName = "Worktables Created/sec",
    unit = "creates/sec",
    description = "Number of work tables created per second, " +
      "usually as a part of tempdb processing when " +
      "working with spools such as table spools, " +
      "index spools, etc.")
  double getWorktablesCreatedPerSec();

  @ManagedMetric(
    displayName = "% Worktables From Cache Ratio",
    unit = "%",
    description = "Percentage of work tables created whose " +
      "initial two pages were immediately available " +
      "from the worktable cache. A value " +
      "less than 90% may indicate insufficient " +
      "memory, since execution plans are being " +
      "dropped."
  )
  double getWorktablesFromCacheRatio();

  @ManagedMetric(
    displayName = "Table Lock Escalations/sec",
    unit = "escalations/sec",
    description = "Number of times that SQL Server escalated " +
      "locks from page- or row-level to " +
      "table-level. This number should, generally, " +
      "be low. Frequent or even occasional " +
      "spiking in this value may indicate poorly " +
      "coded transactions."
  )
  double getTableLockEscalationsPerSec();
}
