package com.octoperf.metrics.iis.api.web.service;


import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Web Service File metrics.")
public interface WebServiceErrorMetrics {

  @ManagedAttribute(description = "Website name.")
  String getInstance();

  @ManagedMetric(
    displayName = "Total Not Found Errors",
    description = "The number of requests that have been made since the service started that were not satisfied by the server because the requested document was not found. Usually reported as HTTP error 404.",
    unit = "errors")
  double getTotalNotFoundErrors();

  @ManagedMetric(
    displayName = "Not Found Errors/sec",
    description = "The rate, in seconds, at which requests were not satisfied by the server because the requested document was not found.",
    unit = "errors/sec")
  double getNotFoundErrorsPerSec();

  @ManagedMetric(
    displayName = "Total Locked Errors",
    description = "The number of requests that have been made since the service started that could not be satisfied by the server because the requested document was locked. Usually reported as HTTP error 423.",
    unit = "errors")
  double getTotalLockedErrors();

  @ManagedMetric(
    displayName = "Locked Errors/sec",
    description = "The rate, in seconds, at which requests were not satisfied because the requested document was locked.",
    unit = "errors")
  double getLockedErrorsPerSec();
}
