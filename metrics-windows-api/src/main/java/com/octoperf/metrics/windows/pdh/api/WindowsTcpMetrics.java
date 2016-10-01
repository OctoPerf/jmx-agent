package com.octoperf.metrics.windows.pdh.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource("Windows:type=TCP")
public interface WindowsTcpMetrics {

  @ManagedMetric(displayName= "Segments/sec", unit = "segments/sec",
  description = "Shows the rate at which TCP segments are sent or received using the TCP protocol. " +
  "Segments/sec is the sum of the values of TCP\\ Segments Received/sec and TCP\\Segments Sent/sec.")
  double getSegmentsPerSec();

  @ManagedMetric(displayName= "Connections Established", unit = "connections",
  description = "Shows the number of TCP connections for which the current state is either ESTABLISHED or CLOSE-WAIT.")
  double getConnectionsEstablished();

  @ManagedMetric(displayName= "Connections Active", unit = "connections",
  description = "Shows the number of times TCP connections have made a direct transition to the SYN-SENT state from the CLOSED state,.")
  double getConnectionsActive();

  @ManagedMetric(displayName= "Connections Passive", unit = "connections",
  description = "Shows the number of times that TCP connections have made a direct transition to the SYN-RCVD state from the LISTEN state.")
  double getConnectionsPassive();

  @ManagedMetric(displayName= "Connection Failures", unit = "connections",
  description = "Shows the number of times that TCP connections have made a direct transition to the CLOSED state " +
  "from the SYN-SENT or SYN-RCVD state, plus the number of times TCP connections have made a direct transition to the LISTEN state from the SYN-RCVD state.")
  double getConnectionFailures();

  @ManagedMetric(displayName= "Connections Reset", unit = "connections",
  description = "Shows the number of times that TCP connections have made a direct transition to the CLOSED state from either the ESTABLISHED or CLOSE-WAIT state.")
  double getConnectionsReset();

  @ManagedMetric(displayName= "Segments Received/sec", unit = "segments/sec",
  description = "Shows the rate at which segments are received, including those received in error. This count includes " +
  "segments received on currently established connections. Segments Received/sec is a subset of TCP: Segments/sec.")
  double getSegmentsReceivedPerSec();

  @ManagedMetric(displayName= "Segments Sent/sec", unit = "segments/sec",
  description = "Shows the rate at which segments are sent. This value includes those on current connections, but " +
  "excludes those containing only retransmitted bytes. Segments Sent/sec is a subset of TCP\\ Segments/sec.")
  double getSegmentsSentPerSec();

  @ManagedMetric(displayName= "Segments Retransmitted/sec", unit = "segments/sec",
  description = "Shows the rate at which segments containing one or more previously transmitted bytes are retransmitted.")
  double getSegmentsRetransmittedPerSec();
}