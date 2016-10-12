package com.octoperf.metrics.iis.api.asp;


import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public interface ASPDotNetAppMetrics {

  @ManagedAttribute(
    description = "ASPNET Application name."
  )
  String getInstance();

  @ManagedMetric(
    displayName = "Anonymous Requests",
    description = "The number of requests that use anonymous authentication.",
    unit = "requests")
  double getAnonymousRequests();

  @ManagedMetric(
    displayName = "Anonymous Requests/sec",
    description = "The average number of requests that have been made per second that use anonymous authentication.",
    unit = "requests/sec")
  double getAnonymousRequestsPerSec();

  @ManagedMetric(
    displayName = "Cache Total Entries",
    description = "The total number of entries in the cache. This counter includes both internal use of the cache by the ASP.NET framework and external use of the cache through exposed APIs.",
    unit = "entries")
  double getCacheTotalEntries();

  @ManagedMetric(
    displayName = "Cache Total Hits",
    description = "The total number of responses served from the cache. This counter includes both internal use of the cache by the ASP.NET framework and external use of the cache through exposed APIs.",
    unit = "hits")
  double getCacheTotalHits();

  @ManagedMetric(
    displayName = "Cache Total Misses",
    description = "The number of failed cache requests. This counter includes both internal use of the cache by ASP.NET and external use of the cache through exposed APIs.",
    unit = "misses")
  double getCacheTotalMisses();

  @ManagedMetric(
    displayName = "Cache Total Hit Ratio",
    description = "The ratio of cache hits to cache misses. This counter includes both internal use of the cache by ASP.NET and external use of the cache through exposed APIs.",
    unit = "hits/misses")
  double getCacheTotalHitRatio();

  @ManagedMetric(
    displayName = "Cache Total Turnover Rate",
    description = "The number of additions to and removals from the cache per second. Use this counter to help determine how efficiently the cache is being used. If the turnover rate is high, the cache is not being used efficiently.",
    unit = "ops/sec")
  double getCacheTotalTurnoverRate();

  @ManagedMetric(
    displayName = "Cache API Entries",
    description = "The total number of entries in the application cache.",
    unit = "entries")
  double getCacheAPIEntries();

  @ManagedMetric(
    displayName = "Cache API Hits",
    description = "The total number of requests served from the cache when it was accessed only through the external cache APIs. This counter does not track use of the cache internally by ASP.NET.",
    unit = "hits")
  double getCacheAPIHits();

  @ManagedMetric(
    displayName = "Cache API Misses",
    description = "The total number of requests to the cache that failed when the cache was accessed through the external cache APIs. This counter does not track use of the cache internally by ASP.NET.",
    unit = "misses")
  double getCacheAPIMisses();

  @ManagedMetric(
    displayName = "Cache API Hit Ratio",
    description = "The cache hit-to-miss ratio when the cache was accessed through external cache APIs. This counter does not track use of the cache internally by ASP.NET.",
    unit = "hits/misses")
  double getCacheAPIHitRatio();

  @ManagedMetric(
    displayName = "Cache API Turnover Rate",
    description = "The number of additions to and removals from the cache per second, when it is used through the external APIs (excluding internal use by the ASP.NET framework). This counter is useful for determining how effectively the cache is being used. If the turnover is great, then the cache is not being used effectively.",
    unit = "turnover")
  double getCacheAPITurnoverRate();

  @ManagedMetric(
    displayName = "Errors During Preprocessing",
    description = "The number of errors that occurred during parsing. Excludes compilation and run-time errors.",
    unit = "errors")
  double getErrorsDuringPreprocessing();

  @ManagedMetric(
    displayName = "Errors During Compilation",
    description = "The number of errors that occurred during dynamic compilation. Excludes parser and run-time errors.",
    unit = "errors")
  double getErrorsDuringCompilation();

  @ManagedMetric(
    displayName = "Errors During Execution",
    description = "The total number of errors that occurred during the execution of an HTTP request. Excludes parser and compilation errors.",
    unit = "errorss")
  double getErrorsDuringExecution();

  @ManagedMetric(
    displayName = "Errors Unhandled During Execution",
    description = "The total number of unhandled errors that occurred during the execution of HTTP requests. An unhandled error is any uncaught run-time exception that escapes user code on the page and enters the ASP.NET internal error-handling logic.",
    unit = "errors")
  double getErrorsUnhandledDuringExecution();

  @ManagedMetric(
    displayName = "Errors Unhandled During Execution/sec",
    description = "The number of unhandled exceptions that occurred per second during the execution of HTTP requests.",
    unit = "errors/sec")
  double getErrorsUnhandledDuringExecutionPerSec();

  @ManagedMetric(
    displayName = "Errors Total",
    description = "The total number of errors that occurred during the execution of HTTP requests. Includes parser, compilation, or run-time errors. This counter represents the sum of the Errors During Compilation, Errors During Preprocessing, and Errors During Execution counters. A well-functioning Web server should not generate errors.",
    unit = "errors")
  double getErrorsTotal();

  @ManagedMetric(
    displayName = "Errors Total/sec",
    description = "The average number of errors that occurred per second during the execution of HTTP requests. Includes any parser, compilation, or run-time errors.",
    unit = "errors/sec")
  double getErrorsTotalPerSec();

  @ManagedMetric(
    displayName = "Output Cache Entries",
    description = "The total number of entries in the output cache.",
    unit = "entries")
  double getOutputCacheEntries();

  @ManagedMetric(
    displayName = "Output Cache Hits",
    description = "The total number of requests serviced from the output cache.",
    unit = "hits")
  double getOutputCacheHits();

  @ManagedMetric(
    displayName = "Output Cache Misses",
    description = "The number of output-cache requests that failed per application.",
    unit = "misses")
  double getOutputCacheMisses();

  @ManagedMetric(
    displayName = "Output Cache Hit Ratio",
    description = "The percentage of total requests that were serviced from the output cache.",
    unit = "%")
  double getOutputCacheHitRatio();

  @ManagedMetric(
    displayName = "Output Cache Turnover Rate",
    description = "The average number of additions to and removals from the output cache per second. If the turnover is great, the cache is not being used effectively.",
    unit = "turnover")
  double getOutputCacheTurnoverRate();

  @ManagedMetric(
    displayName = "Request Bytes In Total",
    description = "The total size, in bytes, of all requests.",
    unit = "bytes")
  double getRequestBytesInTotal();

  @ManagedMetric(
    displayName = "Request Bytes Out Total",
    description = "The total size, in bytes, of responses sent to a client. This does not include standard HTTP response headers.",
    unit = "bytes")
  double getRequestBytesOutTotal();

  @ManagedMetric(
    displayName = "Requests Executing",
    description = "The number of requests that are currently executing.",
    unit = "requests")
  double getRequestsExecuting();

  @ManagedMetric(
    displayName = "Requests Failed",
    description = "The total number of failed requests. All status codes greater than or equal to 400 increment this counter. Note: Requests that cause a 401 status code increment this counter and the Requests Not Authorized counter. Requests that cause a 404 or 414 status code increment this counter and the Requests Not Found counter. Requests that cause a 500 status code increment this counter and the Requests Timed Out counter.",
    unit = "requests")
  double getRequestsFailed();

  @ManagedMetric(
    displayName = "Requests In Application Queue",
    description = "The number of requests in the application request queue.",
    unit = "requests")
  double getRequestsInApplicationQueue();

  @ManagedMetric(
    displayName = "Requests Not Found",
    description = "The number of requests that failed because resources were not found (status code 404, 414).",
    unit = "")
  double getRequestsNotFound();

  @ManagedMetric(
    displayName = "Requests Not Authorized",
    description = "The number of requests that failed because of lack of authorization (status code 401).",
    unit = "requests")
  double getRequestsNotAuthorized();

  @ManagedMetric(
    displayName = "Requests Succeeded",
    description = "The number of requests that executed successfully (status code 200).",
    unit = "requests")
  double getRequestsSucceeded();

  @ManagedMetric(
    displayName = "Requests Timed Out",
    description = "The number of requests that timed out (status code 500).",
    unit = "requests")
  double getRequestsTimedOut();

  @ManagedMetric(
    displayName = "Requests Total",
    description = "The total number of requests that have been made since the service started.",
    unit = "requests")
  double getRequestsTotal();

  @ManagedMetric(
    displayName = "Requests/sec",
    description = "The average number of requests that have been executed per second. This counter represents the current throughput of the application.",
    unit = "request/sec")
  double getRequestsPerSec();

  @ManagedMetric(
    displayName = "Session State Server Connections Total",
    description = "The total number of session-state connections that were made to a computer on which out-of-process session-state data is stored.",
    unit = "connections")
  double getSessionStateServerConnectionsTotal();

  @ManagedMetric(
    displayName = "Session SQL Server Connections Total",
    description = "The total number of session-state connections that were made to the Microsoft SQL Server database in which session-state data is stored.",
    unit = "connections")
  double getSessionSQLServerConnectionsTotal();

  @ManagedMetric(
    displayName = "Sessions Active",
    description = "The number of sessions that are active.",
    unit = "sessions")
  double getSessionsActive();

  @ManagedMetric(
    displayName = "Sessions Abandoned",
    description = "The number of sessions that have been explicitly abandoned.",
    unit = "sessions")
  double getSessionsAbandoned();

  @ManagedMetric(
    displayName = "Sessions Timed Out",
    description = "The number of sessions that timed out.",
    unit = "sessions")
  double getSessionsTimedOut();

  @ManagedMetric(
    displayName = "Sessions Total",
    description = "The total number of sessions.",
    unit = "sessions")
  double getSessionsTotal();

  @ManagedMetric(
    displayName = "Transactions Aborted",
    description = "The number of transactions that were aborted.",
    unit = "transactions")
  double getTransactionsAborted();

  @ManagedMetric(
    displayName = "Transactions Committed",
    description = "The number of transactions that were committed. This counter increments after page execution if the transaction does not abort.",
    unit = "transactions")
  double getTransactionsCommitted();

  @ManagedMetric(
    displayName = "Transactions Pending",
    description = "The number of transactions that are in progress.",
    unit = "transactions")
  double getTransactionsPending();

  @ManagedMetric(
    displayName = "Transactions Total",
    description = "The total number of transactions that have occurred since the service was started.",
    unit = "transactions")
  double getTransactionsTotal();

  @ManagedMetric(
    displayName = "Transactions/sec",
    description = "The average number of transactions that were started per second.",
    unit = "transactions")
  double getTransactionsPerSec();

  @ManagedMetric(
    displayName = "Compilations Total",
    description = "The total number of times that the Web server process dynamically compiled requests for files with .aspx, .asmx, .ascx, or .ashx extensions (or a code-behind source file). Note: This number initially climbs to a peak value as requests are made to all parts of an application. After compilation occurs, however, the resulting binary compilation is saved on disk, where it is reused until its source file changes. This means that, even when a process restarts, the counter can remain at zero (be inactive) until the application is modified or redeployed.",
    unit = "compilations")
  double getCompilationsTotal();

  @ManagedMetric(
    displayName = "Debugging Requests",
    description = "The number of requests that occurred while debugging was enabled.",
    unit = "requests")
  double getDebuggingRequests();

  @ManagedMetric(
    displayName = "Pipeline Instance Count",
    description = "The number of active request pipeline instances for the specified ASP.NET application. Because only one execution thread can run within a pipeline instance, this number represents the maximum number of concurrent requests that are being processed for a specific application. In most circumstances, it is better for this number be low when the server is busy, because this means that the CPU is well used.",
    unit = "pipelines")
  double getPipelineInstanceCount();

}
