package com.octoperf.metrics.iis.pdh.ftp;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.ftp.WebServiceFTPIOMetrics;
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

import static lombok.AccessLevel.PACKAGE;

@Component
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Conditional({IsWindows.class, IsIIS.class})
public final class PdhWSFTPIOMetrics implements WebServiceFTPIOMetrics {
  private static final String FTP_SERVICE = "FTP Service";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getBytesReceivedPerSec() {
    return perSecond("Bytes Received/sec");
  }

  @Override
  public double getBytesSentPerSec() {
    return perSecond("Bytes Sent/sec");
  }

  @Override
  public double getBytesTotalPerSec() {
    return perSecond("Bytes Total/sec");
  }

  @Override
  public double getTotalFilesReceived() {
    return ftp("Total Files Received");
  }

  @Override
  public double getTotalFilesSent() {
    return ftp("Total Files Sent");
  }

  @Override
  public double getTotalFilesTransferred() {
    return ftp("Total Files Transferred");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> ftp(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double ftp(final String counter) {
    return perfmon.getRawValue(FTP_SERVICE, counter);
  }
}
