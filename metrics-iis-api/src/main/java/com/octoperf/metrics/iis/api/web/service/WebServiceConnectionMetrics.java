package com.octoperf.metrics.iis.api.web.service;


import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Connections and Attempts counters for the Web Service performance object.")
public interface WebServiceConnectionMetrics {

  @ManagedAttribute(description = "Website name.")
  String getInstance();

  @ManagedMetric(
    displayName = "Current Connections",
    description = "The number of active connections to the WWW service.",
    unit = "connections")
  double getCurrentConnections();

  @ManagedMetric(
    displayName = "Maximum Connections",
    description = "The maximum number of simultaneous connections made to the WWW service since the service started.",
    unit = "connections")
  double getMaximumConnections();

  @ManagedMetric(
    displayName = "Total Connection Attempts",
    description = "The number of connections to the WWW service that have been attempted since the service started.",
    unit = "connections")
  double getTotalConnectionAttempts();

  @ManagedMetric(
    displayName = "Connection Attempts/sec",
    description = "The rate, in seconds, at which connections to the WWW service have been attempted since the service started.",
    unit = "connections")
  double getConnectionAttemptsPerSec();

  @ManagedMetric(
    displayName = "Total Logon Attempts",
    description = "The number of attempts to log on to the WWW service that have occurred since the service started.",
    unit = "connections")
  double getTotalLongAttempts();

  @ManagedMetric(
    displayName = "Logon Attempts/sec",
    description = "The rate, in seconds, at which attempts to log on to the WWW service have occurred.",
    unit = "connections")
  double getLogonAttemptsPerSec();
}
