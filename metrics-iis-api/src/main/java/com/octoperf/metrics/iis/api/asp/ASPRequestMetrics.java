package com.octoperf.metrics.iis.api.asp;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "IIS:type=ASP,category=Request",
  description = "ASP Debugging and Errors counters for the Active Server Pages performance object.")
public interface ASPRequestMetrics {

  @ManagedMetric(
    displayName = "Request Bytes In Total",
    description = "The total size, in bytes, of all requests.",
    unit = "bytes")
  double getRequestBytesInTotal();

  @ManagedMetric(
    displayName = "Request Bytes Out Total",
    description = "The total size, in bytes, of responses sent to clients. This total does not include standard HTTP response headers.",
    unit = "bytes")
  double getRequestBytesOutTotal();

  @ManagedMetric(
    displayName = "Request Execution Time",
    description = "The number of milliseconds that it took to execute the most recent request.",
    unit = "millis")
  double getRequestExecutionTime();

  @ManagedMetric(
    displayName = "Request Wait Time",
    description = "The number of milliseconds that the most recent request waited in the queue.",
    unit = "millis")
  double getRequestWaitTime();

  @ManagedMetric(
    displayName = "Requests Disconnected",
    description = "The number of requests that were disconnected because communication failed.",
    unit = "requests")
  double getRequestsDisconnected();

  @ManagedMetric(
    displayName = "Requests Executing",
    description = "The number of requests that are currently executing.",
    unit = "requests")
  double getRequestsExecuting();

  @ManagedMetric(
    displayName = "Requests Failed Total",
    description = "The number of requests that failed due to errors, authorization failure, and rejections.",
    unit = "requests")
  double getRequestsFailedTotal();

  @ManagedMetric(
    displayName = "Requests Not Authorized",
    description = "The number of requests that failed because access rights were insufficient.",
    unit = "requests")
  double getRequestsNotAuthorized();

  @ManagedMetric(
    displayName = "Requests Not Found",
    description = "The number of requests that were made for files that were not found.",
    unit = "requests")
  double getRequestsNotFound();

  @ManagedMetric(
    displayName = "Requests Queued",
    description = "The number of requests that are waiting in the queue for service.",
    unit = "requests")
  double getRequestsQueued();

  @ManagedMetric(
    displayName = "Requests Rejected",
    description = "The number of requests that were not executed because there were insufficient resources to process them.",
    unit = "requests")
  double getRequestsRejected();

  @ManagedMetric(
    displayName = "Requests Succeeded",
    description = "The number of requests that executed successfully.",
    unit = "requests")
  double getRequestsSucceeded();

  @ManagedMetric(
    displayName = "Requests Timed Out",
    description = "The number of requests that timed out.",
    unit = "requests")
  double getRequestsTimedOut();

  @ManagedMetric(
    displayName = "Requests Total",
    description = "The number of requests that have been made since the service was started.",
    unit = "requests")
  double getRequestsTotal();

  @ManagedMetric(
    displayName = "Requests/sec",
    description = "The average number of requests that were executed per second.",
    unit = "requests/sec")
  double getRequestsPerSec();

}
