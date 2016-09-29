package com.octoperf.metrics.mssql.api;

import org.springframework.jmx.export.annotation.ManagedAttribute;
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
  description = "The SQLServer:Locks object in Microsoft SQL Server provides " +
    "information about SQL Server locks on individual resource types. "
)
public interface SqlServerLocksMetrics {

  @ManagedAttribute(description = "Lock name.")
  String getInstance();

  @ManagedMetric(
    displayName = "Average Wait Time (ms)",
    unit = "millis",
    description = "Average amount of wait time (in milliseconds) for each lock request that resulted in a wait.")
  double getAverageWaitTimeMs();

  @ManagedMetric(
    displayName = "Lock Requests/sec",
    unit = "requests/sec",
    description = "Number of new locks and lock conversions per second requested from the lock manager.")
  double getLockRequestsPerSec();

  @ManagedMetric(
    displayName = "Lock Timeouts/sec",
    unit = "timeouts/sec",
    description = "Number of lock requests per second that timed out, including requests for NOWAIT locks.")
  double getLockTimeouts();

  @ManagedMetric(
    displayName = "Lock Wait Time (ms)",
    unit = "millis",
    description = "Total wait time (in milliseconds) for locks in the last second.")
  double getLockWaitTimeMs();

  @ManagedMetric(
    displayName = "Lock Waits/sec",
    unit = "waits/sec",
    description = "Number of new locks and lock conversions per second requested from the lock manager.")
  double getLockWaitsPerSec();

  @ManagedMetric(
    displayName = "Number of Deadlocks/sec",
    unit = "deadlocks/sec",
    description = "Number of lock requests per second that resulted in a deadlock.")
  double getNumberOfDeadlocksPerSec();
}
