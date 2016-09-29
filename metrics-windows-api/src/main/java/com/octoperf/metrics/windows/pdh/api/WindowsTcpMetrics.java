package com.octoperf.metrics.windows.pdh.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource("Windows:type=TCP")
public interface WindowsTcpMetrics {

  @ManagedMetric(displayName= "Segments/sec", unit = "segments/sec")
  double getSegmentsPerSec();

  @ManagedMetric(displayName= "Connections Established", unit = "connections")
  double getConnectionsEstablished();

  @ManagedMetric(displayName= "Connections Active", unit = "connections")
  double getConnectionsActive();

  @ManagedMetric(displayName= "Connections Passive", unit = "connections")
  double getConnectionsPassive();

  @ManagedMetric(displayName= "Connection Failures", unit = "connections")
  double getConnectionFailures();

  @ManagedMetric(displayName= "Connections Reset", unit = "connections")
  double getConnectionsReset();

  @ManagedMetric(displayName= "Segments Received/sec", unit = "segments/sec")
  double getSegmentsReceivedPerSec();

  @ManagedMetric(displayName= "Segments Sent/sec", unit = "segments/sec")
  double getSegmentsSentPerSec();

  @ManagedMetric(displayName= "Segments Retransmitted/sec", unit = "segments/sec")
  double getSegmentsRetransmittedPerSec();
}
