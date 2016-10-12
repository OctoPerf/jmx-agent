package com.octoperf.metrics.iis.pdh.web.service;

import com.octoperf.metrics.iis.api.web.service.WebServiceRequestMetrics;
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
public final class PdhWSRequestMetrics implements WebServiceRequestMetrics {
  private static final String WEB_SERVICE = "Web Service(%s)";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @Getter
  @NonNull
  String instance;

  @Override
  public double getCopyRequestsPerSec() {
    return perSecond("Copy Requests/sec");
  }

  @Override
  public double getDeleteRequestsPerSec() {
    return perSecond("Delete Requests/sec");
  }

  @Override
  public double getGetRequestsPerSec() {
    return perSecond("Get Requests/sec");
  }

  @Override
  public double getHeadRequestsPerSec() {
    return perSecond("Head Requests/sec");
  }

  @Override
  public double getLockRequestsPerSec() {
    return perSecond("Lock Requests/sec");
  }

  @Override
  public double getMkcolRequestsPerSec() {
    return perSecond("Mkcol Requests/sec");
  }

  @Override
  public double getMoveRequestsPerSec() {
    return perSecond("Move Requests/sec");
  }

  @Override
  public double getOptionsRequestsPerSec() {
    return perSecond("Options Requests/sec");
  }

  @Override
  public double getOtherRequestMethodsPerSec() {
    return perSecond("Other Request Methods Requests/sec");
  }

  @Override
  public double getPropfindRequestsPerSec() {
    return perSecond("Propfind Requests/sec");
  }

  @Override
  public double getPostRequestsPerSec() {
    return perSecond("Post Requests/sec");
  }

  @Override
  public double getProppatchRequestsPerSec() {
    return perSecond("Proppatch Requests/sec");
  }

  @Override
  public double getPutRequestsPerSec() {
    return perSecond("Put Requests/sec");
  }

  @Override
  public double getSearchRequestsPerSec() {
    return perSecond("Search Requests/sec");
  }

  @Override
  public double getTotalCopyRequests() {
    return ws("Total Copy Requests");
  }

  @Override
  public double getTotalDeleteRequests() {
    return ws("Total Delete Requests");
  }

  @Override
  public double getTotalGetRequests() {
    return ws("Total Get Requests");
  }

  @Override
  public double getTotalHeadRequests() {
    return ws("Total Head Requests");
  }

  @Override
  public double getTotalLockRequests() {
    return ws("Total Lock Requests");
  }

  @Override
  public double getTotalMethodRequests() {
    return ws("Total Method Requests");
  }

  @Override
  public double getTotalMethodRequestsPerSec() {
    return perSecond("Total Method Requests/sec");
  }

  @Override
  public double getTotalMkcolRequests() {
    return ws("Total Mkcol Requests");
  }

  @Override
  public double getTotalMoveRequests() {
    return ws("Total Move Requests");
  }

  @Override
  public double getTotalOptionsRequests() {
    return ws("Total Options Requests");
  }

  @Override
  public double getTotalOtherRequestMethods() {
    return ws("Total Other Request Methods");
  }

  @Override
  public double getTotalPostRequests() {
    return ws("Total Post Requests");
  }

  @Override
  public double getTotalPropfindRequests() {
    return ws("Total Propfind Requests");
  }

  @Override
  public double getTotalProppatchRequests() {
    return ws("Total Proppatch Requests");
  }

  @Override
  public double getTotalPutRequests() {
    return ws("Total Put Requests");
  }

  @Override
  public double getTotalSearchRequests() {
    return ws("Total Search Requests");
  }

  @Override
  public double getTotalTraceRequests() {
    return ws("Total Trace Requests");
  }

  @Override
  public double getTotalUnlockRequests() {
    return ws("Total Unlock Requests");
  }

  @Override
  public double getTraceRequestsPerSec() {
    return perSecond("Trace Requests/sec");
  }

  @Override
  public double getUnlockRequestsPerSec() {
    return perSecond("Unlock Requests/sec");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> ws(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }


  private double ws(final String counter) {
    return perfmon.getRawValue(String.format(WEB_SERVICE, instance), counter);
  }
}
