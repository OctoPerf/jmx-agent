package com.octoperf.metrics.mssql.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "SQLServer:type=GeneralStats",
  description = "The SQLServer:General Statistics object in SQL Server " +
    "provides counters to monitor general server-wide activity, such as " +
    "the number of current connections and the number of users connecting " +
    "and disconnecting per second from computers running an instance of SQL Server."
)
public interface SqlServerGeneralStatsMetrics {

  @ManagedMetric(
    displayName = "Logins/sec",
    unit = "logins/sec",
    description = "Total number of logins started per second. This does not include pooled connections.")
  double getLoginsPerSec();

  @ManagedMetric(
    displayName = "Logouts/sec",
    unit = "logouts/sec",
    description = "Total number of logout operations started per second.")
  double getLogoutsPerSec();

  @ManagedMetric(
    displayName = "Connection resets/sec",
    unit = "resets/sec",
    description = "Total number of logins started from the connection pool.")
  double getConnectionResetsPerSec();

  @ManagedMetric(
    displayName = "Processes blocked",
    unit = "processes",
    description = "Number of currently blocked processes.")
  double getProcessesBlocked();

  @ManagedMetric(
    displayName = "User Connections",
    unit = "connections",
    description = "The number of users currently connected " +
      "to the SQL Server. This counter should " +
      "roughly track with 'Batch Requests/Sec'.")
  double getUserConnections();
}
