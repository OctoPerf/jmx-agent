package com.octoperf.metrics.iis.pdh.asp;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.asp.ASPRequestMetrics;
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
public final class PdhAspRequestMetrics implements ASPRequestMetrics {
  private static final String ASP = "Active Server Pages";

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getRequestBytesInTotal() {
    return asp("Request Bytes In Total");
  }

  @Override
  public double getRequestBytesOutTotal() {
    return asp("Request Bytes Out Total");
  }

  @Override
  public double getRequestExecutionTime() {
    return asp("Request Execution Time");
  }

  @Override
  public double getRequestsDisconnected() {
    return asp("Requests Disconnected");
  }

  @Override
  public double getRequestsExecuting() {
    return asp("Requests Executing");
  }

  @Override
  public double getRequestsFailedTotal() {
    return asp("Requests Failed Total");
  }

  @Override
  public double getRequestsNotAuthorized() {
    return asp("Requests Not Authorized");
  }

  @Override
  public double getRequestsNotFound() {
    return asp("Requests Not Found");
  }

  @Override
  public double getRequestsPerSec() {
    return asp("Requests/sec");
  }

  @Override
  public double getRequestsQueued() {
    return asp("Requests Queued");
  }

  @Override
  public double getRequestsRejected() {
    return asp("Requests Rejected");
  }

  @Override
  public double getRequestsSucceeded() {
    return asp("Requests Succeeded");
  }

  @Override
  public double getRequestsTimedOut() {
    return asp("Requests Timed Out");
  }

  @Override
  public double getRequestsTotal() {
    return asp("Requests Total");
  }

  @Override
  public double getRequestWaitTime() {
    return asp("Requests Wait Time");
  }

  private double asp(final String counter) {
    return perfmon.getRawValue(ASP, counter);
  }
}
