package com.octoperf.metrics.mssql.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * The SQLServer:Latches object in Microsoft SQL Server provides counters to monitor internal SQL Server
 * resource locks called latches. Monitoring the latches to determine user activity
 * and resource usage can help you to identify performance bottlenecks.
 *
 * This table describes the SQL Server Latches counters.
 */
@ManagedResource(
  objectName = "SQLServer:type=Transactions",
  description = "The Transactions object in Microsoft SQL Server provides " +
    "counters to monitor the number of transactions active in an instance of " +
    "the Database Engine, and the effects of those transactions on resources " +
    "such as the snapshot isolation row version store in tempdb."
)
public interface SqlServerTransactionsMetrics {

  @ManagedMetric(
    displayName = "Longest Transaction Running Time",
    unit = "seconds",
    description = "The time, in seconds, of the longest running "+
    "transaction. When blocking is high, "+
    "check this counter to see if transactions "+
    "are open for long periods of time.")
  double getLongestTransactionRunningTimeSec();
}
