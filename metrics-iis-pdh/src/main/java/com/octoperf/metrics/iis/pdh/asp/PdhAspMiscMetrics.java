package com.octoperf.metrics.iis.pdh.asp;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.asp.ASPMiscMetrics;
import com.octoperf.metrics.iis.pdh.IsIIS;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.Set;

import static lombok.AccessLevel.PACKAGE;

@Component
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Conditional({IsWindows.class, IsIIS.class})
public final class PdhAspMiscMetrics implements ASPMiscMetrics {
  private static final String ASP = "Active Server Pages";
  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
      "In Memory Template Cache Hit Rate",
      "Script Engine Cache Hit Rate",
      "Template Cache Hit Rate"
  );

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getEngineFlushNotifications() {
    return asp("Engine Flush Notifications");
  }

  @Override
  public double getInMemoryTemplateCacheHitRate() {
    return formatted("In Memory Template Cache Hit Rate");
  }

  @Override
  public double getInMemoryTemplatesCached() {
    return asp("In Memory Templates Cached");
  }

  @Override
  public double getScriptEngineCacheHitRate() {
    return formatted("Script Engine Cache Hit Rate");
  }

  @Override
  public double getScriptEnginesCached() {
    return asp("Script Engines Cached");
  }

  @Override
  public double getSessionDuration() {
    return asp("Session Duration");
  }

  @Override
  public double getSessionsTimedOut() {
    return asp("Sessions Timed Out");
  }

  @Override
  public double getSessionsCurrent() {
    return asp("Sessions Current");
  }

  @Override
  public double getSessionsTotal() {
    return asp("Sessions Total");
  }

  @Override
  public double getTemplateCacheHitRate() {
    return formatted("Template Cache Hit Rate");
  }

  @Override
  public double getTemplateNotifications() {
    return asp("Template Notifications");
  }

  @Override
  public double getTemplatesCached() {
    return asp("Templates Cached");
  }

  @Override
  public double getTransactionsAborted() {
    return asp("Transactions Aborted");
  }

  @Override
  public double getTransactionsCommitted() {
    return asp("Transactions Commited");
  }

  @Override
  public double getTransactionsPerSec() {
    return perSecond("Transactions/sec");
  }

  @Override
  public double getTransactionsTotal() {
    return asp("Transactions Total");
  }

  @Override
  public double getTransactionsPending() {
    return asp("Transactions Pending");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> asp(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double asp(final String counter) {
    return perfmon.getRawValue(ASP, counter);
  }

  private double formatted(final String counter) {
    return perfmon
        .getFormattedValues(ASP, FORMATTED_COUNTERS)
        .getOrDefault(counter, 0d);
  }
}
