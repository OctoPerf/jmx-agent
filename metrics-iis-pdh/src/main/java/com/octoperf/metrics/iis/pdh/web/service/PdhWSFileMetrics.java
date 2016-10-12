package com.octoperf.metrics.iis.pdh.web.service;

import com.octoperf.metrics.iis.api.web.service.WebServiceFileMetrics;
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
public final class PdhWSFileMetrics implements WebServiceFileMetrics {
  private static final String WEB_SERVICE = "Web Service(%s)";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @Getter
  @NonNull
  String instance;

  @Override
  public double getFilesPerSec() {
    return perSecond("Files/sec");
  }

  @Override
  public double getFilesReceivedPerSec() {
    return perSecond("Files Received/sec");
  }

  @Override
  public double getFilesSentPerSec() {
    return perSecond("Files Sent/sec");
  }

  @Override
  public double getTotalFilesReceived() {
    return ws("Total Files Received");
  }

  @Override
  public double getTotalFilesSent() {
    return ws("Total Files Sent");
  }

  @Override
  public double getTotalFilesTransferred() {
    return ws("Total Files Transferred");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> ws(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }


  private double ws(final String counter) {
    return perfmon.getRawValue(String.format(WEB_SERVICE, instance), counter);
  }
}
