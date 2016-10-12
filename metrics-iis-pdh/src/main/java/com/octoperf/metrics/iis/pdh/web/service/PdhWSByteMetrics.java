package com.octoperf.metrics.iis.pdh.web.service;

import com.octoperf.metrics.iis.api.web.service.WebServiceByteMetrics;
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
public final class PdhWSByteMetrics implements WebServiceByteMetrics {
  private static final String WEB_SERVICE = "Web Service(%s)";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @Getter
  @NonNull
  String instance;

  @Override
  public double getBytesReceivedPerSec() {
    return perSecond("Bytes Received/sec");
  }

  @Override
  public double getBytesSentPerSec() {
    return perSecond("Bytes Sent/sec");
  }

  @Override
  public double getBytesTransferredPerSec() {
    return perSecond("Bytes Transferred/sec");
  }

  @Override
  public double getTotalBytesReceived() {
    return ws("Total Bytes Received");
  }

  @Override
  public double getTotalBytesSent() {
    return ws("Total Bytes Sent");
  }

  @Override
  public double getTotalBytesTransferred() {
    return ws("Total Bytes Transferred");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> ws(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }


  private double ws(final String counter) {
    return perfmon.getRawValue(String.format(WEB_SERVICE, instance), counter);
  }
}
