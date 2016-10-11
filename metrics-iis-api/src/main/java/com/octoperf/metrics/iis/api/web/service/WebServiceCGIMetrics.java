package com.octoperf.metrics.iis.api.web.service;


import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Common Gateway Interface (CGI) Requests and ISAPI Extension Requests counters for the Web Service performance object.")
public interface WebServiceCGIMetrics {

  @ManagedAttribute(description = "Website name.")
  String getInstance();

  @ManagedMetric(
    displayName = "Current CGI Requests",
    description = "The number of CGI requests that are being processed simultaneously by the WWW service.",
    unit = "requests")
  double getCurrentCGIRequests();

  @ManagedMetric(
    displayName = "Total CGI Requests",
    description = "The number of all CGI requests that have been made since the WWW service started.",
    unit = "requests")
  double getTotalCGIRequests();

  @ManagedMetric(
    displayName = "CGI Requests/sec",
    description = "The rate, in seconds, at which CGI requests are being processed simultaneously by the WWW service.",
    unit = "requests/sec")
  double getCGIRequestsPerSec();

  @ManagedMetric(
    displayName = "Maximum CGI Requests",
    description = "The maximum number of CGI requests that have been processed simultaneously by the WWW service since the service started.",
    unit = "requests")
  double getMaximumCGIRequests();

  @ManagedMetric(
    displayName = "Current ISAPI Extension Requests",
    description = "The number of ISAPI extension requests that are being processed simultaneously by the WWW service.",
    unit = "requests")
  double getCurrentISAPIExtensionRequests();

  @ManagedMetric(
    displayName = "Total ISAPI Extension Requests",
    description = "The number of ISAPI extension requests that have been made since the WWW service started.",
    unit = "requests")
  double getTotalISAPIExtensionRequests();

  @ManagedMetric(
    displayName = "ISAPI Extension Requests/sec",
    description = "The rate, in seconds, at which ISAPI extension requests are being processed by the WWW service.",
    unit = "requests/sec")
  double getISAPIExtensionRequestsPerSec();

  @ManagedMetric(
    displayName = "Maximum ISAPI Extension Requests",
    description = "The maximum number of ISAPI extension requests that were processed simultaneously by the WWW service.",
    unit = "requests")
  double getMaximumISAPIExtensionRequests();

}
