package com.octoperf.metrics.iis.pdh.ftp;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.ftp.WebServiceFTPConnectionMetrics;
import com.octoperf.metrics.iis.pdh.IsIIS;
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
public final class PdhWSFTPConnectionMetrics implements WebServiceFTPConnectionMetrics {
  private static final String FTP_SERVICE = "FTP Service";

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getCurrentConnections() {
    return ftp("Current Connections");
  }

  @Override
  public double getFTPServiceUptime() {
    return ftp("FTP Service Uptime");
  }

  @Override
  public double getMaximumConnections() {
    return ftp("Maximum Connections");
  }

  @Override
  public double getTotalConnectionAttempts() {
    return ftp("Total Connection Attempts");
  }

  @Override
  public double getTotalLogonAttempts() {
    return ftp("Total Logon Attempts");
  }

  private double ftp(final String counter) {
    return perfmon.getRawValue(FTP_SERVICE, counter);
  }
}
