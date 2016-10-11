package com.octoperf.metrics.iis.api.web.service;


import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Web Service File metrics.")
public interface WebServiceFileMetrics {

  @ManagedAttribute(description = "Website name.")
  String getInstance();

  @ManagedMetric(
    displayName = "Total Files Sent",
    description = "The number of user-mode files that have been sent by the WWW service since the service started. This counter does not include cache hits. Note that this counter does not increment when files are being served from the kernel-mode cache.",
    unit = "files")
  double getTotalFilesSent();

  @ManagedMetric(
    displayName = "Files Sent/sec",
    description = "The rate, in seconds, at which files have been sent.",
    unit = "files/sec")
  double getFilesSentPerSec();

  @ManagedMetric(
    displayName = "Files Sent/sec",
    description = "The rate, in seconds, at which files have been sent.",
    unit = "files/sec")
  double getTotalFilesReceived();

  @ManagedMetric(
    displayName = "Files Received/sec",
    description = "The rate, in seconds, at which files have been received by the WWW service.",
    unit = "files/sec")
  double getFilesReceivedPerSec();

  @ManagedMetric(
    displayName = "Total Files Transferred",
    description = "The sum of Total Files Sent and Total Files Received by the WWW service since the service started. Note that this counter does not increment when files are being served from the kernel-mode cache.",
    unit = "filess")
  double getTotalFilesTransferred();

  @ManagedMetric(
    displayName = "Files/sec",
    description = "The rate, in seconds, at which files have been sent and received by the WWW service.",
    unit = "files/sec")
  double getFilesPerSec();
}
