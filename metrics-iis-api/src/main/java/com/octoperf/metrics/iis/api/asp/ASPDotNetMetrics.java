package com.octoperf.metrics.iis.api.asp;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "IIS:type=ASP,category=dotNET",
  description = "ASP.NET supports the following ASP.NET system performance counters, " +
    "which aggregate information for all ASP.NET applications on a Web server computer, " +
    "or, alternatively, apply generally to a system of ASP.NET servers running the same applications.")
public interface ASPDotNetMetrics {

  @ManagedMetric(
    displayName = "Application Restarts",
    description = "The number of times that an application has been restarted since the Web service started. Application restarts are incremented with each Application_OnEnd event. An application restart can occur because changes were made to the Web.config file or to assemblies stored in the application's \\Bin directory, or because too many changes occurred in Web Forms pages. Sudden increases in this counter can mean that your Web application is shutting down. If an unexpected increase occurs, be sure to investigate it promptly. This value resets every time IIS is restarted.",
    unit = "restarts")
  double getApplicationRestarts();

  @ManagedMetric(
    displayName = "Applications Running",
    description = "The number of applications that are running on the server computer.",
    unit = "applications")
  double getApplicationsRunning();

  @ManagedMetric(
    displayName = "Requests Disconnected",
    description = "The number of requests that were disconnected because a communication failure occurred.",
    unit = "requests")
  double getRequestsDisconnected();

  @ManagedMetric(
    displayName = "Requests Queued",
    description = "The number of requests in the queue waiting to be serviced. If this number increases as the number of client requests increases, the Web server has reached the limit of concurrent requests that it can process. The default maximum for this counter is 5,000 requests. You can change this setting in the computer's Machine.config file.",
    unit = "requests")
  double getRequestsQueued();

  @ManagedMetric(
    displayName = "Requests Rejected",
    description = "The total number of requests that were not executed because insufficient server resources existed to process them. This counter represents the number of requests that return a 503 HTTP status code, which indicates that the server is too busy.",
    unit = "requests")
  double getRequestsRejected();

  @ManagedMetric(
    displayName = "Request Wait Time",
    description = "The number of milliseconds that the most recent request waited in the queue for processing.",
    unit = "millis")
  double getRequestWaitTime();

  @ManagedMetric(
    displayName = "State Server Sessions Abandoned",
    description = "The number of user sessions that were explicitly abandoned. These are sessions that have been ended by specific user actions, such as closing the browser or navigating to another site.",
    unit = "sessions")
  double getStateServerSessionsAbandoned();

  @ManagedMetric(
    displayName = "State Server Sessions Active",
    description = "The number of active user sessions.",
    unit = "sessions")
  double getStateServerSessionsActive();

  @ManagedMetric(
    displayName = "State Server Sessions Timed Out",
    description = "The number of user sessions that are now inactive. In this case, the user is inactive, not the server.",
    unit = "sessions")
  double getStateServerSessionsTimedOut();

  @ManagedMetric(
    displayName = "State Server Sessions Total",
    description = "The number of sessions created during the lifetime of the process. This counter represents the cumulative value of State Server Sessions Active, State Server Sessions Abandoned, and State Server Sessions Timed Out counters.",
    unit = "sessions")
  double getStateServerSessionsTotal();

  @ManagedMetric(
    displayName = "Worker Process Restarts",
    description = "The number of times that a worker process restarted on the server computer. A worker process can be restarted if it fails unexpectedly or when it is intentionally recycled. If worker process restarts increase unexpectedly, investigate immediately.",
    unit = "restarts")
  double getWorkerProcessRestarts();

  @ManagedMetric(
    displayName = "Worker Processes Running",
    description = "The number of worker processes that are running on the server computer.",
    unit = "workers")
  double getWorkerProcessesRunning();

}
