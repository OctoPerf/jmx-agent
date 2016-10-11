package com.octoperf.metrics.iis.api.ftp;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "IIS:type=FTP,category=IO",
  description = "Bytes and Total Files counters for the FTP Service performance object.")
public interface WebServiceFTPIOMetrics {

  @ManagedMetric(
    displayName = "Bytes Sent/sec",
    description = "The rate at which data bytes are being sent by the FTP service.",
    unit = "bytes/sec")
  double getBytesSentPerSec();

  @ManagedMetric(
    displayName = "Bytes Received/sec",
    description = "The rate at which data bytes are being received by the FTP service.",
    unit = "bytes/sec")
  double getBytesReceivedPerSec();

  @ManagedMetric(
    displayName = "Bytes Total/sec",
    description = "The sum of Bytes Sent/sec and Bytes Received/sec.",
    unit = "bytes/sec")
  double getBytesTotalPerSec();

  @ManagedMetric(
    displayName = "Total Files Sent",
    description = "The total number of files that have been sent by the FTP service since the service started.",
    unit = "files")
  double getTotalFilesSent();

  @ManagedMetric(
    displayName = "Total Files Received",
    description = "The total number of files that have been received by the FTP service since the service started.",
    unit = "files")
  double getTotalFilesReceived();

  @ManagedMetric(
    displayName = "Total Files Transferred",
    description = "The sum of Total Files Sent and Total Files Received. This is the total number of files transferred by the FTP service since the service started.",
    unit = "files")
  double getTotalFilesTransferred();
}
