package com.octoperf.metrics.iis.api.web.service;


import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Web Service Bytes Sent and Received metrics.")
public interface WebServiceByteMetrics {

  @ManagedAttribute(description = "Website name.")
  String getInstance();

  @ManagedMetric(
    displayName = "Total Bytes Sent",
    description = "The number of data bytes that have been sent by the WWW service since the service started.",
    unit = "bytes")
  double getTotalBytesSent();

  @ManagedMetric(
    displayName = "Bytes Sent/sec",
    description = "The rate, in seconds, at which data bytes have been sent by the WWW service.",
    unit = "bytes/sec")
  double getBytesSentPerSec();

  @ManagedMetric(
    displayName = "Total Bytes Received",
    description = "The total bytes of data that have been received by the WWW service since the service started.",
    unit = "bytes")
  double getTotalBytesReceived();

  @ManagedMetric(
    displayName = "Bytes Received/sec",
    description = "The rate, in seconds, at which data bytes have been received by the WWW service.",
    unit = "bytes/sec")
  double getBytesReceivedPerSec();

  @ManagedMetric(
    displayName = "Total Bytes Transferred",
    description = "The total number of bytes of data that have been sent and received by the WWW service since the service started.",
    unit = "bytes")
  double getTotalBytesTransferred();

  @ManagedMetric(
    displayName = "Bytes Transferred/sec",
    description = "The sum of Bytes Sent/sec and Bytes Received/sec.",
    unit = "bytes/sec")
  double getBytesTransferredPerSec();
}
