package com.octoperf.metrics.api;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

import static org.springframework.jmx.support.MetricType.COUNTER;

@ManagedResource
public interface NetworkInterfaceMetrics {

  @ManagedAttribute(description = "Network interface name.")
  String getName();

  @ManagedMetric(metricType = COUNTER, description = "Received Megabytes.")
  double getRxMegabytes();

  @ManagedMetric(metricType = COUNTER, description = "Dropped Packets.")
  long getRxDropped();

  @ManagedMetric(metricType = COUNTER, description = "Rx Error Packets.")
  long getRxErrors();

  @ManagedMetric(metricType = COUNTER, description = "Rx Frames.")
  long getRxFrames();

  @ManagedMetric(metricType = COUNTER, description = "Rx Overruns.")
  long getRxOverruns();

  @ManagedMetric(metricType = COUNTER, description = "Megabytes Sent.")
  double getTxMegabytes();

  @ManagedMetric(metricType = COUNTER, description = "Packets Received.")
  long getRxPackets();

  @ManagedMetric(metricType = COUNTER, description = "Carrier Sent.")
  long getTxCarrier();

  @ManagedMetric(metricType = COUNTER, description = "Packet Collisions.")
  long getTxCollisions();

  @ManagedMetric(metricType = COUNTER, description = "Packet Collisions.")
  long getTxDropped();

  @ManagedMetric(metricType = COUNTER, description = "Tx Errors.")
  long getTxErrors();

  @ManagedMetric(metricType = COUNTER, description = "Tx Overruns.")
  long getTxOverruns();

  @ManagedMetric(metricType = COUNTER, description = "Tx Packets sent.")
  long getTxPackets();

  @ManagedMetric(metricType = COUNTER, description = "Network card speed.")
  long getSpeed();
}
