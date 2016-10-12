package com.octoperf.metrics.iis.pdh.ftp;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.ftp.WebServiceFTPUserMetrics;
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
public final class PdhWSFTPUserMetrics implements WebServiceFTPUserMetrics {
  private static final String FTP_SERVICE = "FTP Service";

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getCurrentAnonymousUsers() {
    return ftp("Current Anonymous Users");
  }

  @Override
  public double getCurrentNonAnonymousUsers() {
    return ftp("Current NonAnonymous Users");
  }

  @Override
  public double getMaximumNonAnonymousUsers() {
    return ftp("Maximum NonAnonymous Users");
  }

  @Override
  public double getTotalAnonymousUsers() {
    return ftp("Total Anonymous Users");
  }

  @Override
  public double getTotalNonAnonymousUsers() {
    return ftp("Total NonAnonymous Users");
  }

  @Override
  public double getMaximumAnonymousUsers() {
    return ftp("Maximum Anonymous Users");
  }

  private double ftp(final String counter) {
    return perfmon.getRawValue(FTP_SERVICE, counter);
  }
}
