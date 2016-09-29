package com.octoperf.metrics.sigar.network;

import com.octoperf.metrics.api.NetworkInterfaceMetrics;
import com.octoperf.metrics.service.api.UnitConversionService;
import javaslang.control.Try;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.NetInterfaceStat;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;


@Builder
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class SigarNetworkInterfaceMetrics implements NetworkInterfaceMetrics {
  public static final double ONE_MEGABYTE = 1_048_576d;

  @Getter
  @NonNull
  String name;
  @NonNull
  Try.CheckedSupplier<NetInterfaceStat> stats;
  @NonNull
  UnitConversionService units;

  @Override
  public double getRxMegabytes() {
    return units.map(stats, NetInterfaceStat::getRxBytes, 0L) / ONE_MEGABYTE;
  }

  @Override
  public long getRxDropped() {
    return units.map(stats, NetInterfaceStat::getRxDropped, 0L);
  }

  @Override
  public long getRxPackets() {
    return units.map(stats, NetInterfaceStat::getRxPackets, 0L);
  }

  @Override
  public long getRxErrors() {
    return units.map(stats, NetInterfaceStat::getRxErrors, 0L);
  }

  @Override
  public long getRxFrames() {
    return units.map(stats, NetInterfaceStat::getRxFrame, 0L);
  }

  @Override
  public long getRxOverruns() {
    return units.map(stats, NetInterfaceStat::getRxOverruns, 0L);
  }

  @Override
  public double getTxMegabytes() {
    return units.map(stats, NetInterfaceStat::getTxBytes, 0L) / ONE_MEGABYTE;
  }

  @Override
  public long getTxCarrier() {
    return units.map(stats, NetInterfaceStat::getTxCarrier, 0L);
  }

  @Override
  public long getTxCollisions() {
    return units.map(stats, NetInterfaceStat::getTxCollisions, 0L);
  }

  @Override
  public long getTxDropped() {
    return units.map(stats, NetInterfaceStat::getTxDropped, 0L);
  }

  @Override
  public long getTxErrors() {
    return units.map(stats, NetInterfaceStat::getTxErrors, 0L);
  }

  @Override
  public long getTxOverruns() {
    return units.map(stats, NetInterfaceStat::getTxOverruns, 0L);
  }

  @Override
  public long getTxPackets() {
    return units.map(stats, NetInterfaceStat::getTxPackets, 0L);
  }

  @Override
  public long getSpeed() {
    return units.map(stats, NetInterfaceStat::getSpeed, 0L);
  }
}
