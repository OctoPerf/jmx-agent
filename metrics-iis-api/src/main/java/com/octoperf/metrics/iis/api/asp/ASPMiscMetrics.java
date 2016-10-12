package com.octoperf.metrics.iis.api.asp;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "IIS:type=ASP,category=Miscellaneous",
  description = "ASP Debugging and Errors counters for the Active Server Pages performance object.")
public interface ASPMiscMetrics {

  @ManagedMetric(
    displayName = "Script Engines Cached",
    description = "The number of script engines in the cache.",
    unit = "engines")
  double getScriptEnginesCached();

  @ManagedMetric(
    displayName = "Script Engine Cache Hit Rate",
    description = "The percentage of requests that were found in the script engine cache.",
    unit = "%")
  double getScriptEngineCacheHitRate();

  @ManagedMetric(
    displayName = "Engine Flush Notifications",
    description = "The number of engines invalidated in the cache because change notification occurred.",
    unit = "engines")
  double getEngineFlushNotifications();

  @ManagedMetric(
    displayName = "Session Duration",
    description = "The length of time that the most recent session lasted, in milliseconds.",
    unit = "millis")
  double getSessionDuration();

  @ManagedMetric(
    displayName = "Sessions Current",
    description = "The number of sessions currently being serviced.",
    unit = "sessions")
  double getSessionsCurrent();

  @ManagedMetric(
    displayName = "Sessions Timed Out",
    description = "The number of sessions that have timed out.",
    unit = "sessions")
  double getSessionsTimedOut();

  @ManagedMetric(
    displayName = "Sessions Total",
    description = "The number of sessions that have run since the service was started.",
    unit = "sessions")
  double getSessionsTotal();

  @ManagedMetric(
    displayName = "Templates Cached",
    description = "The number of templates that are currently cached.",
    unit = "templates")
  double getTemplatesCached();

  @ManagedMetric(
    displayName = "Template Cache Hit Rate",
    description = "The percentage of requests that have been found in the template cache.",
    unit = "%")
  double getTemplateCacheHitRate();

  @ManagedMetric(
    displayName = "Template Notifications",
    description = "The number of templates that have been invalidated in the cache because change notification occurred.",
    unit = "templates")
  double getTemplateNotifications();

  @ManagedMetric(
    displayName = "In Memory Templates Cached",
    description = "The number of compiled templates that are cached in memory.",
    unit = "templates")
  double getInMemoryTemplatesCached();

  @ManagedMetric(
    displayName = "In Memory Template Cache Hit Rate",
    description = "The percentage of requests that have been found in the memory cache.",
    unit = "%")
  double getInMemoryTemplateCacheHitRate();

  @ManagedMetric(
    displayName = "Transactions Aborted",
    description = "The number of transactions that have been aborted.",
    unit = "transactions")
  double getTransactionsAborted();

  @ManagedMetric(
    displayName = "Transactions Committed",
    description = "The number of transactions that have been committed. This counter increments after page execution if the transaction does not abort.",
    unit = "transactions")
  double getTransactionsCommitted();

  @ManagedMetric(
    displayName = "Transactions Pending",
    description = "The number of transactions that are in progress.",
    unit = "transactions")
  double getTransactionsPending();

  @ManagedMetric(
    displayName = "Transactions Total",
    description = "The number of transactions that have occurred since the service was started.",
    unit = "transactions")
  double getTransactionsTotal();

  @ManagedMetric(
    displayName = "Transactions/sec",
    description = "The average number of transactions that have been started, per second.",
    unit = "transactions")
  double getTransactionsPerSec();

}
