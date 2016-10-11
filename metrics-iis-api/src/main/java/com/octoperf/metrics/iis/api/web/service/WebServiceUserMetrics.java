package com.octoperf.metrics.iis.api.web.service;


import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  description = "With Anonymous and NonAnonymous Users counters, " +
    "IIS 6.x counts each request as a new user. This behavior differs " +
    "from IIS 5.x, which counted each connection as a new user.")
public interface WebServiceUserMetrics {

  @ManagedAttribute(description = "Website name.")
  String getInstance();

  @ManagedMetric(
    displayName = "Current Anonymous Users",
    description = "The number of users who currently have an anonymous request pending with the WWW service. In IIS 6.0, Current Users (Anonymous or NonAnonymous) is the number of requests currently being worked on by the server.",
    unit = "users")
  double getCurrentAnonymousUsers();

  @ManagedMetric(
    displayName = "Current NonAnonymous  Users",
    description = "The number of users who currently have a nonanonymous request pending with the WWW service. In IIS 6.0, Current Users (Anonymous or NonAnonymous) is the number of requests currently being worked on by the server.",
    unit = "users")
  double getCurrentNonAnonymousUsers();

  @ManagedMetric(
    displayName = "Total Anonymous Users",
    description = "The number of users who have established an anonymous request since the WWW service started. This counter does not increment when files are being served from the kernel cache.",
    unit = "users")
  double getTotalAnonymousUsers();

  @ManagedMetric(
    displayName = "Anonymous Users/sec",
    description = "The rate, in seconds, at which users have made anonymous requests to the WWW service.",
    unit = "users/sec")
  double getAnonymousUsersPerSec();

  @ManagedMetric(
    displayName = "Total NonAnonymous Users",
    description = "The number of users who have made nonanonymous requests to the WWW service since the service started.",
    unit = "users")
  double getTotalNonAnonymousUsers();

  @ManagedMetric(
    displayName = "NonAnonymous Users/sec",
    description = "The rate, in seconds, at which users have made nonanonymous requests to the WWW service.",
    unit = "users/sec")
  double getNonAnonymousUsersPerSec();

  @ManagedMetric(
    displayName = "Maximum NonAnonymous Users",
    description = "The maximum number of users who have made concurrent nonanonymous requests to the WWW service since the service started.",
    unit = "users")
  double getMaximumNonAnonymousUsers();

}
