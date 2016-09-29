package com.octoperf.metrics.windows.pdh.api;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public interface WindowsNetworkInterfaceMetrics {

  @ManagedAttribute(description = "Network Interface.")
  String getInstance();

  @ManagedMetric(
    displayName = "Bytes Total/sec",
    unit = "bytes/sec",
    description = "Bytes Total/sec")
  double getBytesTotalPerSec();

  @ManagedMetric(
    displayName = "Packets/sec",
    unit = "packets/sec",
    description = "Packets/sec")
  double getPacketsPerSec();

  @ManagedMetric(
    displayName = "Packets Received/sec",
    unit = "packets/sec",
    description = "Packets Received/sec")
  double getPacketsReceivedPerSec();

  @ManagedMetric(
    displayName = "Packets Sent/sec",
    unit = "packets/sec",
    description = "Packets Sent/sec")
  double getPacketsSentPerSec();

  @ManagedMetric(
    displayName = "Current Bandwidth",
    unit = "bits",
    description = "Current Bandwidth")
  double getCurrentBandwidth();

  @ManagedMetric(
    displayName = "Bytes Received/sec",
    unit = "bytes/sec",
    description = "Bytes Received/sec")
  double getBytesReceivedPerSec();

  @ManagedMetric(
    displayName = "Packets Received Unicast/sec",
    unit = "packets/sec",
    description = "Packets Received Unicast/sec")
  double getPacketsReceivedUnicastPerSec();

  @ManagedMetric(
    displayName = "Packets Received Non-Unicast/sec",
    unit = "packets/sec",
    description = "Packets Received Non-Unicast/sec")
  double getPacketsReceivedNonUnicastPerSec();

  @ManagedMetric(
    displayName = "Packets Received Discarded",
    unit = "packets",
    description = "Packets Received Discarded")
  double getPacketsReceivedDiscarded();

  @ManagedMetric(
    displayName = "Packets Received Errors",
    unit = "packets",
    description = "Packets Received Errors")
  double getPacketsReceivedErrors();

  @ManagedMetric(
    displayName = "Packets Received Unknown",
    unit = "packets",
    description = "Packets Received Unknown")
  double getPacketsReceivedUnknown();

  @ManagedMetric(
    displayName = "Bytes Sent/sec",
    unit = "bytes/sec",
    description = "Bytes Sent/sec")
  double getBytesSentPerSec();

  @ManagedMetric(
    displayName = "Bytes Sent Unicast/sec",
    unit = "bytes/sec",
    description = "Bytes Sent Unicast/sec")
  double getBytesSentUnicastPerSec();

  @ManagedMetric(
    displayName = "Packets Sent Unicast/sec",
    unit = "packets/sec",
    description = "Packets Sent Unicast/sec")
  double getPacketsSentUnicastPerSec();

  @ManagedMetric(
    displayName = "Packets Sent Non-Unicast/sec",
    unit = "packets/sec",
    description = "Packets Sent Non-Unicast/sec")
  double getPacketsSentNonUnicastPerSec();

  @ManagedMetric(
    displayName = "Packets Outbound Discarded",
    unit = "packets",
    description = "Packets Outbound Discarded")
  double getPacketsOutboundDiscarded();

  @ManagedMetric(
    displayName = "Packets Outbound Errors",
    unit = "packets",
    description = "Packets Outbound Errors")
  double getPacketsOutboundErrors();

  @ManagedMetric(
    displayName = "Output Queue Length",
    unit = "length",
    description = "Output Queue Length")
  double getOutputQueueLength();

  @ManagedMetric(
    displayName = "Offloaded Connections",
    unit = "connections",
    description = "Offloaded Connections")
  double getOffloadedConnections();

  @ManagedMetric(
    displayName = "TCP Active RSC Connections",
    unit = "connections",
    description = "TCP Active RSC Connections")
  double getTCPActiveRSCConnections();

  @ManagedMetric(
    displayName = "TCP RSC Coalesced Packets/sec",
    unit = "packets/sec",
    description = "TCP RSC Coalesced Packets/sec")
  double getTCPRSCCoalescedPacketsPerSec();

  @ManagedMetric(
    displayName = "TCP RSC Exceptions/sec",
    unit = "packets/sec",
    description = "TCP RSC Exceptions/sec")
  double getTCPRSCExceptionsPerSec();

  @ManagedMetric(
    displayName = "TCP RSC Average Packet Size",
    unit = "packet size",
    description = "TCP RSC Average Packet Size")
  double getTCPRSCAveragePacketSize();
}
