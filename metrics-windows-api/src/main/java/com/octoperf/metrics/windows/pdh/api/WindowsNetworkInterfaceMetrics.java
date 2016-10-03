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
    description = "Shows the rate at which bytes are sent and received on the network interface, including " +
  "framing characters. Bytes Total/sec is the sum of the values of Network Interface\\Bytes Received/sec and Network Interface\\ Bytes Sent/sec.")
  double getBytesTotalPerSec();

  @ManagedMetric(
    displayName = "Packets/sec",
    unit = "packets/sec",
    description = "Length of output packet queue per second.")
  double getPacketsPerSec();

  @ManagedMetric(
    displayName = "Packets Received/sec",
    unit = "packets/sec",
    description = "Shows the rate at which packets are received on the network interface.")
  double getPacketsReceivedPerSec();

  @ManagedMetric(
    displayName = "Packets Sent/sec",
    unit = "packets/sec",
    description = "Shows the rate at which packets are sent on the network interface.")
  double getPacketsSentPerSec();

  @ManagedMetric(
    displayName = "Current Bandwidth",
    unit = "bits",
    description = "Shows an estimate of the current bandwidth of the network interface in " +
    "bits per second (BPS). For interfaces that do not vary in bandwidth or for those where no accurate estimation can be made, this value is the nominal bandwidth.")
  double getCurrentBandwidth();

  @ManagedMetric(
    displayName = "Bytes Received/sec",
    unit = "bytes/sec",
    description = "Shows the rate at which bytes are received over each network adapter. " +
    "The counted bytes include framing characters. Bytes Received/sec is a subset of Network Interface\\Bytes Total/sec.")
  double getBytesReceivedPerSec();

  @ManagedMetric(
    displayName = "Packets Received Unicast/sec",
    unit = "packets/sec",
    description = "Shows the rate at which subnet-unicast packets are delivered to a higher-layer protocol.")
  double getPacketsReceivedUnicastPerSec();

  @ManagedMetric(
    displayName = "Packets Received Non-Unicast/sec",
    unit = "packets/sec",
    description = "Shows the rate at which non-unicast (subnet broadcast or subnet multicast) packets are delivered to a higher-layer protocol.")
  double getPacketsReceivedNonUnicastPerSec();

  @ManagedMetric(
    displayName = "Packets Received Discarded",
    unit = "packets",
    description = "Shows the number of inbound packets that were chosen to be discarded even " +
    "though no errors had been detected to prevent their being deliverable to a higher-layer protocol. " +
    "One possible reason for discarding such a packet could be to free up buffer space.")
  double getPacketsReceivedDiscarded();

  @ManagedMetric(
    displayName = "Packets Received Errors",
    unit = "packets",
    description = "Shows the number of inbound packets that contained errors preventing them from being deliverable to a higher-layer protocol.")
  double getPacketsReceivedErrors();

  @ManagedMetric(
    displayName = "Packets Received Unknown",
    unit = "packets",
    description = "Shows the number of packets received through the interface that were discarded because of an unknown or unsupported protocol.")
  double getPacketsReceivedUnknown();

  @ManagedMetric(
    displayName = "Bytes Sent/sec",
    unit = "bytes/sec",
    description = "Shows the rate at which bytes are sent over each network adapter. The counted " +
    "bytes include framing characters. Bytes Sent/sec is a subset of Network Interface Bytes Total/sec.")
  double getBytesSentPerSec();

  @ManagedMetric(
    displayName = "Bytes Sent Unicast/sec",
    unit = "bytes/sec",
    description = "Shows the rate at which bytes are requested to be transmitted to subnet-unicast addresses by higher-level protocols.")
  double getBytesSentUnicastPerSec();

  @ManagedMetric(
    displayName = "Packets Sent Unicast/sec",
    unit = "packets/sec",
    description = "Shows the rate at which packets are requested to be transmitted to subnet-unicast " +
    "addresses by higher-level protocols. The rate includes the packets that were discarded or not sent.")
  double getPacketsSentUnicastPerSec();

  @ManagedMetric(
    displayName = "Packets Sent Non-Unicast/sec",
    unit = "packets/sec",
    description = "Shows the rate at which packets are requested to be transmitted to nonunicast " +
    "(subnet broadcast or subnet multicast) addresses by higher-level protocols. The rate includes packets that were discarded or not sent.")
  double getPacketsSentNonUnicastPerSec();

  @ManagedMetric(
    displayName = "Packets Outbound Discarded",
    unit = "packets",
    description = "Shows the number of outbound packets to be discarded even though no errors had " +
    "been detected to prevent transmission. One possible reason for discarding the a packet could be to free up buffer space.")
  double getPacketsOutboundDiscarded();

  @ManagedMetric(
    displayName = "Packets Outbound Errors",
    unit = "packets",
    description = "Shows the number of outbound packets that could not be transmitted because of errors.")
  double getPacketsOutboundErrors();

  @ManagedMetric(
    displayName = "Output Queue Length",
    unit = "length",
    description = "Shows the length of the output packet queue, in packets. If this is longer than two, " +
    "there are delays and the bottleneck should be found and eliminated, if possible. Since the requests " +
    "are queued by Network Driver Interface Specification (NDIS) in this implementation, this value is always 0.")
  double getOutputQueueLength();

  @ManagedMetric(
    displayName = "Offloaded Connections",
    unit = "connections",
    description = "Number of Offloaded Connections on this interface.")
  double getOffloadedConnections();

  @ManagedMetric(
    displayName = "TCP Active RSC Connections",
    unit = "connections",
    description = "Number of active TCP Receive Segment Coalescing connections.")
  double getTCPActiveRSCConnections();

  @ManagedMetric(
    displayName = "TCP RSC Coalesced Packets/sec",
    unit = "packets/sec",
    description = "Number of RSC coalesced packets per second.")
  double getTCPRSCCoalescedPacketsPerSec();

  @ManagedMetric(
    displayName = "TCP RSC Exceptions/sec",
    unit = "packets/sec",
    description = "Number RSC of exceptions per second.")
  double getTCPRSCExceptionsPerSec();

  @ManagedMetric(
    displayName = "TCP RSC Average Packet Size",
    unit = "packet size",
    description = "Average packet size for TCP Receive Segment Coalescing connections.")
  double getTCPRSCAveragePacketSize();
}
