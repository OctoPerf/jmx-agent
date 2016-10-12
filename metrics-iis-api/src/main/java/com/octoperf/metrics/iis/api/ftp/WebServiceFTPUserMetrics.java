package com.octoperf.metrics.iis.api.ftp;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "IIS:type=FTP,category=User",
  description = "Anonymous and NonAnonymous Users counters for the FTP Service performance object.")
public interface WebServiceFTPUserMetrics {

  @ManagedMetric(
    displayName = "Maximum NonAnonymous Users",
    description = "The maximum number of users who have established concurrent nonanonymous connections using the FTP service since the service started.",
    unit = "users")
  double getMaximumNonAnonymousUsers();

  @ManagedMetric(
    displayName = "Maximum Anonymous Users",
    description = "The maximum number of users who have established concurrent anonymous connections using the FTP service since the service started.",
    unit = "users")
  double getMaximumAnonymousUsers();

  @ManagedMetric(
    displayName = "Total NonAnonymous Users",
    description = "The number of users who have established nonanonymous connections with the FTP service since the service started.",
    unit = "users")
  double getTotalNonAnonymousUsers();

  @ManagedMetric(
    displayName = "Total Anonymous Users",
    description = "The number of users who have established an anonymous connection with the FTP service since the service started.",
    unit = "users")
  double getTotalAnonymousUsers();

  @ManagedMetric(
    displayName = "Current NonAnonymous Users",
    description = "The number of users who currently have a nonanonymous connection that was made by using the FTP service.",
    unit = "users")
  double getCurrentNonAnonymousUsers();

  @ManagedMetric(
    displayName = "Current Anonymous Users",
    description = "The number of users who currently have an anonymous connection that was made by using the FTP service.",
    unit = "users")
  double getCurrentAnonymousUsers();
}
