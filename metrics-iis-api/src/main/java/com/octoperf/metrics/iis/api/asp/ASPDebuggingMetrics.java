package com.octoperf.metrics.iis.api.asp;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "IIS:type=ASP,category=Debugging",
  description = "ASP Debugging and Errors counters for the Active Server Pages performance object.")
public interface ASPDebuggingMetrics {

  @ManagedMetric(
    displayName = "ASP Debugging Requests",
    description = "The number of requests for debugging documents that have been made since the WWW service started.",
    unit = "requests")
  double getASPDebuggingRequests();

  @ManagedMetric(
    displayName = "Errors During Script Runtime",
    description = "The number of requests that failed because run-time errors occurred.",
    unit = "errors")
  double getErrorsDuringScriptRuntime();

  @ManagedMetric(
    displayName = "Errors From ASP Preprocessor",
    description = "The number of requests that failed because preprocessor errors occurred.",
    unit = "errors")
  double getErrorsFromASPPreprocessor();

  @ManagedMetric(
    displayName = "Errors From Script Compilers",
    description = "The number of requests that failed because script compilation errors occurred.",
    unit = "errors")
  double getErrorsFromScriptCompilers();

  @ManagedMetric(
    displayName = "Errors/sec",
    description = "The average number of errors that occurred per second.",
    unit = "errors/sec")
  double getErrorsPerSec();

}
