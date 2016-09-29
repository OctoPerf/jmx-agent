package com.octoperf.metrics.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

import static org.springframework.jmx.support.MetricType.COUNTER;

@ManagedResource("Sigar:type=TCP")
public interface TcpMetrics {

  @ManagedMetric(metricType = COUNTER)
  long getActiveConnectionOpenings();

  @ManagedMetric(metricType = COUNTER)
  long getFailedConnectionAttempts();

  @ManagedMetric(metricType = COUNTER)
  long getPassiveConnectionOpenings();

  @ManagedMetric(metricType = COUNTER)
  long getConnectionsEstablished();

  @ManagedMetric(metricType = COUNTER)
  long getConnectionResets();

  @ManagedMetric(metricType = COUNTER)
  long getSegmentRetransmitted();

  @ManagedMetric(metricType = COUNTER)
  long getBadSegmentsReceived();

  @ManagedMetric(metricType = COUNTER)
  long getSegmentsSentOut();

  @ManagedMetric(metricType = COUNTER)
  long getResetsSent();
}
