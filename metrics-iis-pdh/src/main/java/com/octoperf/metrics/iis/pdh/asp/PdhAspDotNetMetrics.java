package com.octoperf.metrics.iis.pdh.asp;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.asp.ASPDotNetMetrics;
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
public final class PdhAspDotNetMetrics implements ASPDotNetMetrics {
  private static final String ASP_DOT_NET = "ASP.NET";

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getRequestWaitTime() {
    return asp("Request Wait Time");
  }

  @Override
  public double getRequestsRejected() {
    return asp("Requests Rejected");
  }

  @Override
  public double getApplicationRestarts() {
    return asp("Application Restarts");
  }

  @Override
  public double getApplicationsRunning() {
    return asp("Applications Running");
  }

  @Override
  public double getRequestsDisconnected() {
    return asp("Requests Disconnected");
  }

  @Override
  public double getStateServerSessionsAbandoned() {
    return asp("State Server Sessions Abandoned");
  }

  @Override
  public double getStateServerSessionsActive() {
    return asp("State Server Sessions Active");
  }

  @Override
  public double getRequestsQueued() {
    return asp("Requests Queued");
  }

  @Override
  public double getStateServerSessionsTimedOut() {
    return asp("State Server Sessions Timed out");
  }

  @Override
  public double getStateServerSessionsTotal() {
    return asp("State Server Sessions Total");
  }

  @Override
  public double getWorkerProcessesRunning() {
    return asp("Worker Processes Running");
  }

  @Override
  public double getWorkerProcessRestarts() {
    return asp("Worker Processes Restarts");
  }

  private double asp(final String counter) {
    return perfmon.getRawValue(ASP_DOT_NET, counter);
  }
}
