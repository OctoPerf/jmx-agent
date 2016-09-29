package com.octoperf.metrics.windows.pdh;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.octoperf.metrics.windows.pdh.api.WindowsNetworkInterfaceMetrics;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.win32.Pdh;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import java.util.concurrent.TimeUnit;

import static lombok.AccessLevel.PACKAGE;

@ConditionalOnBean(Pdh.class)
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhNetworkInterfaceMetrics implements WindowsNetworkInterfaceMetrics {
  private static final String IFACE = "Network Interface(%s)";
  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @Getter
  @NonNull
  String instance;

  @Override
  public double getBytesTotalPerSec() {
    return perSecond("Bytes Total/sec");
  }

  @Override
  public double getPacketsPerSec() {
    return perSecond("Packets/sec");
  }

  @Override
  public double getPacketsReceivedPerSec() {
    return perSecond("Packets Received/sec");
  }

  @Override
  public double getPacketsSentPerSec() {
    return perSecond("Packets Sent/sec");
  }

  @Override
  public double getCurrentBandwidth() {
    return raw("Current Bandwidth");
  }

  @Override
  public double getBytesReceivedPerSec() {
    return perSecond("Bytes Received/sec");
  }

  @Override
  public double getPacketsReceivedUnicastPerSec() {
    return perSecond("Packets Received Unicast/sec");
  }

  @Override
  public double getPacketsReceivedNonUnicastPerSec() {
    return perSecond("Packets Received Non-Unicast/sec");
  }

  @Override
  public double getPacketsReceivedDiscarded() {
    return raw("Packets Received Discarded");
  }

  @Override
  public double getPacketsReceivedErrors() {
    return raw("Packets Received Errors");
  }

  @Override
  public double getPacketsReceivedUnknown() {
    return raw("Packets Received Unknown");
  }

  @Override
  public double getBytesSentPerSec() {
    return perSecond("Bytes Sent/sec");
  }

  @Override
  public double getBytesSentUnicastPerSec() {
    return perSecond("Bytes Sent Unicast/sec");
  }

  @Override
  public double getPacketsSentUnicastPerSec() {
    return perSecond("Packets Sent Unicast/sec");
  }

  @Override
  public double getPacketsSentNonUnicastPerSec() {
    return perSecond("Packets Sent Non-Unicast/sec");
  }

  @Override
  public double getPacketsOutboundDiscarded() {
    return raw("Packets Outbound Discarded");
  }

  @Override
  public double getPacketsOutboundErrors() {
    return raw("Packets Outbound Errors");
  }

  @Override
  public double getOutputQueueLength() {
    return raw("Output Queue Length");
  }

  @Override
  public double getOffloadedConnections() {
    return raw("Offloaded Connections");
  }

  @Override
  public double getTCPActiveRSCConnections() {
    return raw("TCP Active RSC Connections");
  }

  @Override
  public double getTCPRSCCoalescedPacketsPerSec() {
    return perSecond("TCP RSC Coalesced Packets/sec");
  }

  @Override
  public double getTCPRSCExceptionsPerSec() {
    return perSecond("TCP RSC Exceptions/sec");
  }

  @Override
  public double getTCPRSCAveragePacketSize() {
    return raw("TCP RSC Average Packet Size");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> raw(counter);
    return gauges.cached(instance + counter, gauges.perSecond(gauge)).getValue();
  }

  private double raw(final String counter) {
    return perfmon.getRawValue(String.format(IFACE, instance), counter);
  }
}
