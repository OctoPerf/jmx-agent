package com.octoperf.metrics.mssql.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "SQLServer:type=SQLStats",
  description = "The SQLServer:SQL Statistics object in SQL Server provides " +
    "counters to monitor compilation and the type of requests sent to an instance of " +
    "SQL Server. Monitoring the number of query compilations and recompilations " +
    "and the number of batches received by an instance of SQL Server gives you an " +
    "indication of how quickly SQL Server is processing user queries and how " +
    "effectively the query optimizer is processing the queries.")
public interface SqlServerSqlStatsMetrics {

  @ManagedMetric(
    displayName = "Auto-Param Attempts/sec",
    unit = "attempts/sec",
    description = "Number of auto-parameterization attempts per second. Total should be the sum of the " +
      "failed, safe, and unsafe auto-parameterizations. Auto-parameterization occurs when an " +
      "instance of SQL Server attempts to reuse a cached plan for a previously executed query " +
      "that is similar to, but not the same as, the current query. For more information, see Autoparameterization " +
      "in the SQL Server Books On-Line (BOL).")
  double getAutoParamAttemptsPerSec();

  @ManagedMetric(
    displayName = "Failed Auto-Params/sec",
    unit = "attempts/sec",
    description = "Number of failed auto-parameterization attempts per second. This should be small.")
  double getFailedAutoParamsPerSec();

  @ManagedMetric(
    displayName = "Safe Auto-Params/sec",
    unit = "attempts/sec",
    description = "Number of safe auto-parameterization attempts per second.")
  double getSafeAutoParamsPerSec();

  @ManagedMetric(
    displayName = "Unsafe Auto-Params/sec",
    unit = "attempts/sec",
    description = "A query is designated as unsafe when it has characteristics that prevent its cached plan " +
      "from being shared.")
  double getUnsafeAutoParamsPerSec();

  @ManagedMetric(
    displayName = "Batch Requests/Sec",
    unit = "requests/sec",
    description = "Number of Transact-SQL command batches received per second. " +
      "This statistic is affected by all constraints (such as I/O, number of users, cache size, " +
      "complexity of requests, and so on). High batch requests mean good throughput."
  )
  double getBatchRequestsPerSec();

  @ManagedMetric(
    displayName = "SQL Compilations/sec",
    unit = "compil./sec",
    description = "Number of times that Transact-SQL compilations " +
      "occurred, per second (including recompiles). " +
      "The lower this value is the better."
  )
  double getSQLCompilationsPerSec();

  @ManagedMetric(
    displayName = "SQL Re-Compilations/sec",
    unit = "recompil./sec",
    description = "Number of statement recompiles per second. " +
      "Counts the number of times statement recompiles are triggered. " +
      "Generally, you want the recompiles to be low."
  )
  double getSQLReCompilationsPerSec();

  @ManagedMetric(
    displayName = "SQL Attention Rate/sec",
    unit = "attentions/sec",
    description = "Number of cancels and query timeouts occurring " +
      "per second. This number should be as low as " +
      "possible. A high sustained number indicates " +
      "frequent query timeout or end-user cancellation " +
      "of queries."
  )
  double getSQLAttentionsPerSec();
}
