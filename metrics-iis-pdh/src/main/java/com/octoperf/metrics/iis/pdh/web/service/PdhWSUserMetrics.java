package com.octoperf.metrics.iis.pdh.web.service;

import com.octoperf.metrics.iis.api.web.service.WebServiceUserMetrics;
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
public final class PdhWSUserMetrics implements WebServiceUserMetrics {
  private static final String WEB_SERVICE = "Web Service(%s)";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @Getter
  @NonNull
  String instance;

  @Override
  public double getAnonymousUsersPerSec() {
    return perSecond("Anonymous Users/sec");
  }

  @Override
  public double getCurrentAnonymousUsers() {
    return ws("Current Anonymous Users");
  }

  @Override
  public double getCurrentNonAnonymousUsers() {
    return ws("Current NonAnonymous Users");
  }

  @Override
  public double getMaximumNonAnonymousUsers() {
    return ws("Maximum NonAnonymous Users");
  }

  @Override
  public double getNonAnonymousUsersPerSec() {
    return perSecond("NonAnonymous Users/sec");
  }

  @Override
  public double getTotalAnonymousUsers() {
    return ws("Total Anonymous Users");
  }

  @Override
  public double getTotalNonAnonymousUsers() {
    return ws("Total NonAnonymous Users");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> ws(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }


  private double ws(final String counter) {
    return perfmon.getRawValue(String.format(WEB_SERVICE, instance), counter);
  }
}
