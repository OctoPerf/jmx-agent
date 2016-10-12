package com.octoperf.metrics.iis.pdh.web.service;

import com.octoperf.metrics.iis.api.web.service.WebServiceConnectionMetrics;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PACKAGE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhWSConnectionMetrics implements WebServiceConnectionMetrics {
  private static final String WEB_SERVICE = "Web Service(%s)";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @Getter
  @NonNull
  String instance;

  @Override
  public double getConnectionAttemptsPerSec() {
    return perSecond("Connection Attempts/sec");
  }

  @Override
  public double getCurrentConnections() {
    return ws("Current Connections");
  }

  @Override
  public double getLogonAttemptsPerSec() {
    return perSecond("Logon Attempts/sec");
  }

  @Override
  public double getMaximumConnections() {
    return ws("Maximum Connections");
  }

  @Override
  public double getTotalConnectionAttempts() {
    return ws("Total Connection Attempts");
  }

  @Override
  public double getTotalLogonAttempts() {
    return ws("Total Logon Attempts");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> ws(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }


  private double ws(final String counter) {
    return perfmon.getRawValue(String.format(WEB_SERVICE, instance), counter);
  }
}
