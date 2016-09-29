package com.octoperf.metrics.mssql.api;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Monitor these counters to determine " +
  "general benchmark levels set by your user databases and for tempdb.")
public interface SqlServerDatabaseMetrics {

  @ManagedAttribute(description = "User Database name.")
  String getInstance();

  @ManagedMetric(
    displayName = "Data File(s) Size (KB)",
    unit = "KB",
    description = "Cumulative size (KB) of all the data files in the " +
      "database including any automatic growth. " +
      "Monitoring this counter is useful, for example, " +
      "for determining the correct size of tempdb.")
  double getDataFilesSizeKB();

  @ManagedMetric(
    displayName = "Log Bytes Flushed/sec",
    unit = "bytes/sec",
    description = "Total number of log bytes flushed per second. " +
      "Useful for determining trends and utilization of " +
      "the transaction log")
  double getLogBytesFlushedPerSec();

  @ManagedMetric(
    displayName = "Log File(s) Size (KB)",
    unit = "KBytes",
    description = "Cumulative size, in (KB), of all the transaction log " +
      "files for the specific database. Useful for determining " +
      "trends and utilization of the transaction " +
      "log.")
  double getLogFilesSizeKB();

  @ManagedMetric(
    displayName = "Log File(s) Used Size (KB)",
    unit = "KBytes",
    description = "The cumulative used size of all the log files in the " +
      "database.")
  double getLogFilesUsedSizeKB();

  @ManagedMetric(
    displayName = "Log Flush Wait Time",
    unit = "millis",
    description = "Total wait time, in milliseconds, to write all transaction " +
      "log pages.")
  double getLogFlushWaitTime();

  @ManagedMetric(
    displayName = "Log Flush Waits/sec",
    unit = "waits/sec",
    description = "Effectively, the number of times per second that " +
      "SQL Server must wait for pages to be written to " +
      "the transaction log.")
  double getLogFlushWaitsPerSec();

  @ManagedMetric(
    displayName = "Log Flushes/sec",
    unit = "flushes/sec",
    description = "Technically, the number of log pages flushed to " +
      "the transaction log per second.")
  double getLogFlushesPerSec();

  @ManagedMetric(
    displayName = "Log Growths",
    unit = "flushes/sec",
    description = "Total number of times the transaction log for " +
      "the database has been expanded. Each time the " +
      "transaction log grows, all user activity must halt " +
      "until the log growth completes. Therefore, you " +
      "want log growths to occur during predefined " +
      "maintenance windows rather than during general " +
      "working hours.")
  double getLogGrowths();

  @ManagedMetric(
    displayName = "Log Shrinks",
    unit = "shrinks",
    description = "Total number of times the transaction log for the " +
      "database has been shrunk.")
  double getLogShrinks();

  @ManagedMetric(
    displayName = "Log Truncations",
    unit = "truncations",
    description = "Total number of times the transaction log has " +
      "been truncated for the database specified. " +
      "Truncations should happen during log backups " +
      "or, on databases in simple recovery mode, at " +
      "checkpoint or the time period specified by " +
      "recovery interval.")
  double getLogTruncations();

  @ManagedMetric(
    displayName = "% Log Used",
    unit = "%",
    description = "Percent Log Used")
  double getPercentLogUsed();
}
