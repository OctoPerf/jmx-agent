package com.octoperf.metrics.iis.pdh.asp;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.asp.ASPDotNetAppMetrics;
import com.octoperf.metrics.iis.pdh.IsIIS;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.lang.String.format;
import static lombok.AccessLevel.PACKAGE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhASPDotNetAppMetrics implements ASPDotNetAppMetrics {
  private static final String ASP_DOT_NET_APP = "ASP.NET Applications(%s)";
  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
      "Cache API Hit Ratio",
      "Cache API Turnover Rate",
      "Cache Total Hit Ratio",
      "Cache Total Turnover Rate",
      "Output Cache Hit Ratio",
      "Output Cache Turnover Rate"
  );

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @Getter
  @NonNull
  String instance;

  @Override
  public double getAnonymousRequests() {
    return app("Anonymous Requests");
  }

  @Override
  public double getAnonymousRequestsPerSec() {
    return perSecond("Anonymous Requests/sec");
  }

  @Override
  public double getCacheAPIEntries() {
    return app("Cache API Entries");
  }

  @Override
  public double getCacheAPIHitRatio() {
    return formatted("Cache API Hit Ratio");
  }

  @Override
  public double getCacheAPIHits() {
    return app("Cache API Hits");
  }

  @Override
  public double getCacheAPIMisses() {
    return app("Cache API Misses");
  }

  @Override
  public double getCacheAPITurnoverRate() {
    return formatted("Cache API Turnover Rate");
  }

  @Override
  public double getCacheTotalEntries() {
    return app("Cache Total Entries");
  }

  @Override
  public double getCacheTotalHitRatio() {
    return formatted("Cache Total Hit Ratio");
  }

  @Override
  public double getCacheTotalHits() {
    return app("Cache Total Hits");
  }

  @Override
  public double getCacheTotalMisses() {
    return app("Cache Total Misses");
  }

  @Override
  public double getCacheTotalTurnoverRate() {
    return formatted("Cache Total Turnover Rate");
  }

  @Override
  public double getCompilationsTotal() {
    return app("Compilations Total");
  }

  @Override
  public double getDebuggingRequests() {
    return app("Debugging Requests");
  }

  @Override
  public double getErrorsDuringCompilation() {
    return app("Errors During Compilation");
  }

  @Override
  public double getErrorsDuringExecution() {
    return app("Errors During Execution");
  }

  @Override
  public double getErrorsDuringPreprocessing() {
    return app("Errors During Preprocessing");
  }

  @Override
  public double getErrorsTotal() {
    return app("Errors Total");
  }

  @Override
  public double getErrorsTotalPerSec() {
    return perSecond("Errors Total/sec");
  }

  @Override
  public double getOutputCacheEntries() {
    return app("Output Cache Entries");
  }

  @Override
  public double getErrorsUnhandledDuringExecution() {
    return app("Errors Unhandled During Execution");
  }

  @Override
  public double getErrorsUnhandledDuringExecutionPerSec() {
    return perSecond("Errors Unhandled During Execution/sec");
  }

  @Override
  public double getOutputCacheHitRatio() {
    return formatted("Output Cache Hit Ratio");
  }

  @Override
  public double getOutputCacheHits() {
    return app("Output Cache Hits");
  }

  @Override
  public double getOutputCacheMisses() {
    return app("Output Cache Misses");
  }

  @Override
  public double getOutputCacheTurnoverRate() {
    return formatted("Output Cache Turnover Rate");
  }

  @Override
  public double getPipelineInstanceCount() {
    return app("Pipeline Instance Count");
  }

  @Override
  public double getRequestBytesInTotal() {
    return app("Request Bytes In Total");
  }

  @Override
  public double getRequestBytesOutTotal() {
    return app("Request Bytes Out Total");
  }

  @Override
  public double getRequestsExecuting() {
    return app("Requests Executing");
  }

  @Override
  public double getRequestsFailed() {
    return app("Requests Failed");
  }

  @Override
  public double getRequestsInApplicationQueue() {
    return app("Requests In Application Queue");
  }

  @Override
  public double getRequestsNotAuthorized() {
    return app("Requests Not Authorized");
  }

  @Override
  public double getRequestsNotFound() {
    return app("Requests Not Found");
  }

  @Override
  public double getRequestsPerSec() {
    return app("Requests/sec");
  }

  @Override
  public double getRequestsSucceeded() {
    return app("Requests Succeeded");
  }

  @Override
  public double getRequestsTimedOut() {
    return app("Requests Timed Out");
  }

  @Override
  public double getRequestsTotal() {
    return app("Requests Total");
  }

  @Override
  public double getSessionsAbandoned() {
    return app("Sessions Abandoned");
  }

  @Override
  public double getSessionsActive() {
    return app("Sessions Active");
  }

  @Override
  public double getSessionSQLServerConnectionsTotal() {
    return app("Session SQL Server Connections Total");
  }

  @Override
  public double getSessionStateServerConnectionsTotal() {
    return app("Session State Server Connections Total");
  }

  @Override
  public double getSessionsTimedOut() {
    return app("Sessions Timed Out");
  }

  @Override
  public double getSessionsTotal() {
    return app("Sessions Total");
  }

  @Override
  public double getTransactionsAborted() {
    return app("Transactions Aborted");
  }

  @Override
  public double getTransactionsCommitted() {
    return app("Transactions Committed");
  }

  @Override
  public double getTransactionsPending() {
    return app("Transactions Pending");
  }

  @Override
  public double getTransactionsPerSec() {
    return app("Transactions/sec");
  }

  @Override
  public double getTransactionsTotal() {
    return app("Transactions Total");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> app(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double app(final String counter) {
    return perfmon.getRawValue(format(ASP_DOT_NET_APP, instance), counter);
  }

  private double formatted(final String counter) {
    return perfmon
        .getFormattedValues(format(ASP_DOT_NET_APP, instance), FORMATTED_COUNTERS)
        .getOrDefault(counter, 0d);
  }
}
