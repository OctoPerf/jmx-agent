package com.octoperf.metrics.mssql.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "SQLServer:type=MemoryManager")
public interface SqlServerMemoryManagerMetrics {

  @ManagedMetric(
    displayName = "Granted Workspace Memory (KB)",
    unit = "KBytes",
    description = "Specifies the total amount of memory " +
      "currently granted to executing processes, such as hash, " +
      "sort, bulk copy, and index creation operations.")
  double getGrantedWorkspaceMemoryKB();

  @ManagedMetric(
    displayName = "Maximum Workspace Memory (KB)",
    unit = "KBytes",
    description = "Maximum amount of memory available for executing processes such as hash, " +
      "sort, bulk copy, and index creation operations.")
  double getMaximumWorkspaceMemoryKB();

  @ManagedMetric(
    displayName = "Memory Grants Outstanding",
    unit = "processes",
    description = "Total number of processes per second that have successfully acquired a " +
      "workspace memory grant.")
  double getMemoryGrantsOutstanding();

  @ManagedMetric(
    displayName = "Memory Grants Pending",
    unit = "processes",
    description = "Total number of processes per second waiting for a workspace memory grant. " +
      "Numbers higher than 0 indicate a lack of memory.")
  double getMemoryGrantsPending();

  @ManagedMetric(
    displayName = "Total Server Memory (KB)",
    unit = "KBytes",
    description = "Shows the amount of memory that SQL Server " +
      "is currently using. This value should grow until " +
      "its equal to Target Server Memory, as it populates " +
      "its caches and loads pages into memory. " +
      "When it has finished, SQL Server is said to be in " +
      "a 'steady-state'. Until it is in steady-state, performance " +
      "may be slow and IO may be higher")
  double getTotalServerMemoryKB();

  @ManagedMetric(
    displayName = "Target Server Memory (KB)",
    unit = "KBytes",
    description = "Total amount of dynamic memory the server can consume.")
  double getTargetServerMemoryKB();
}

