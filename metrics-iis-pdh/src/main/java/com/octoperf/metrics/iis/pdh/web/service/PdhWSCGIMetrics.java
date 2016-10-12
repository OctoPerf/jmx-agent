package com.octoperf.metrics.iis.pdh.web.service;

import com.octoperf.metrics.iis.api.web.service.WebServiceCGIMetrics;
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
public final class PdhWSCGIMetrics implements WebServiceCGIMetrics {
  private static final String WEB_SERVICE = "Web Service(%s)";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @Getter
  @NonNull
  String instance;

  @Override
  public double getCGIRequestsPerSec() {
    return perSecond("CGI Requests/sec");
  }

  @Override
  public double getCurrentCGIRequests() {
    return ws("Current CGI Requests");
  }

  @Override
  public double getCurrentISAPIExtensionRequests() {
    return ws("Current ISAPI Extension Requests");
  }

  @Override
  public double getISAPIExtensionRequestsPerSec() {
    return perSecond("ISAPI Extension Requests/sec");
  }

  @Override
  public double getMaximumCGIRequests() {
    return ws("Maximum CGI Requests");
  }

  @Override
  public double getMaximumISAPIExtensionRequests() {
    return ws("Maximum ISAPI Extension Requests");
  }

  @Override
  public double getTotalCGIRequests() {
    return ws("Total CGI Requests");
  }

  @Override
  public double getTotalISAPIExtensionRequests() {
    return ws("Total ISAPI Extension Requests");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> ws(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }


  private double ws(final String counter) {
    return perfmon.getRawValue(String.format(WEB_SERVICE, instance), counter);
  }
}
