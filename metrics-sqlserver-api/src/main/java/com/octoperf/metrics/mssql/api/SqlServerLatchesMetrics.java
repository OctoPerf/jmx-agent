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
  objectName = "SQLServer:type=Latches",
  description = "The SQLServer:Latches object in Microsoft SQL Server provides counters to monitor internal SQL Server " +
    "resource locks called latches. Monitoring the latches to determine user activity " +
    "and resource usage can help you to identify performance bottlenecks."
)
public interface SqlServerLatchesMetrics {

  @ManagedMetric(
    displayName = "Average Latch Wait Time (ms)",
    unit = "millis",
    description = "The average latch wait time, in milliseconds, " +
      "for any latch requests that had to " +
      "wait. This value should generally correlate " +
      "to “Latch Waits/sec” and move up or down " +
      "with it accordingly.")
  double getAverageLatchWaitTimeMs();

  @ManagedMetric(
    displayName = "Latch Waits/sec",
    unit = "waits/sec",
    description = "The number of latches in the last second " +
      "that had to wait. Latches are lightweight " +
      "means of holding a very transient server " +
      "resource, such as an address in memory.")
  double getLatchWaitsPerSec();

  @ManagedMetric(
    displayName = "Number of SuperLatches",
    unit = "latches",
    description = "Current number of SuperLatches.")
  double getNumberOfSuperLatches();

  @ManagedMetric(
    displayName = "SuperLatch Demotions/sec",
    unit = "demotions/sec",
    description = "Number of latches that have been demoted from SuperLatches in the last second.")
  double getSuperLatchDemotionsPerSec();

  @ManagedMetric(
    displayName = "SuperLatch Promotions/sec",
    unit = "promotions/sec",
    description = "Number of latches that have been promoted to SuperLatches in the last second.")
  double getSuperLatchPromotionsPerSec();

  @ManagedMetric(
    displayName = "Total Latch Wait Time (ms)",
    unit = "millis",
    description = "The total latch wait time in milliseconds" +
      "spent waiting for a latch in the last" +
      "second. This value should stay stable" +
      "compared to the number of latch waits" +
      "per second.")
  double getTotalLatchWaitTimeMs();
}
