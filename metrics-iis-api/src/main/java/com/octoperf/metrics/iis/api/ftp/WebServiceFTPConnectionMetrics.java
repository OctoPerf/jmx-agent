package com.octoperf.metrics.iis.api.ftp;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "IIS:type=FTP,category=IO",
  description = "Bytes and Total Files counters for the FTP Service performance object.")
public interface WebServiceFTPConnectionMetrics {

  @ManagedMetric(
    displayName = "Current Connections",
    description = "The current number of connections that have been established with the FTP service.",
    unit = "connections")
  double getCurrentConnections();

  @ManagedMetric(
    displayName = "Maximum Connections",
    description = "The maximum number of simultaneous connections that have been established with the FTP service.",
    unit = "connections")
  double getMaximumConnections();

  @ManagedMetric(
    displayName = "Total Connection Attempts (all instances)",
    description = "The number of connections that have been attempted by using the FTP service since the service started. This counter applies to all instances listed.",
    unit = "attempts")
  double getTotalConnectionAttempts();

  @ManagedMetric(
    displayName = "Total Logon Attempts",
    description = "The number of logons that have been attempted by using the FTP service since the service started.",
    unit = "attempts")
  double getTotalLogonAttempts();

  @ManagedMetric(
    displayName = "FTP Service Uptime",
    description = "The amount of time, in seconds, that the FTP service has been running.",
    unit = "seconds")
  double getFTPServiceUptime();
}
