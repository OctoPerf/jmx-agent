package com.octoperf.metrics.sigar.process;

import com.octoperf.metrics.api.ProcessMetrics;
import com.octoperf.metrics.service.api.UnitConversionService;
import javaslang.control.Try;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.ProcCpu;
import org.hyperic.sigar.ProcMem;

import static com.octoperf.metrics.sigar.network.SigarNetworkInterfaceMetrics.ONE_MEGABYTE;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Builder
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class SigarProcessMetrics implements ProcessMetrics {
  public static final long ONE_SECOND = 1000L;
  @Getter
  @NonNull
  String name;
  @Getter
  long pid;
  @NonNull
  Try.CheckedSupplier<ProcMem> memory;
  @NonNull
  Try.CheckedSupplier<ProcCpu> cpu;
  @NonNull
  UnitConversionService units;

  @Override
  public double getPercentCpuUsage() {
    return units.map(cpu, ProcCpu::getPercent, 0d) * 100d;
  }

  @Override
  public long getUserCpuTimeSec() {
    return units.map(cpu, ProcCpu::getUser, 0L) / ONE_SECOND;
  }

  @Override
  public long getSysCpuTimeSec() {
    return units.map(cpu, ProcCpu::getSys, 0L) / ONE_SECOND;
  }

  @Override
  public long getTotalCpuTimeSec() {
    return units.map(cpu, ProcCpu::getTotal, 0L) / ONE_SECOND;
  }

  @Override
  public double getVirtualMemSizeMb() {
    return units.map(memory, ProcMem::getSize, 0L) / ONE_MEGABYTE;
  }

  @Override
  public double getResidentMemSizeMb() {
    return units.map(memory, ProcMem::getResident, 0L) / ONE_MEGABYTE;
  }

  @Override
  public double getShareMemSizeMb() {
    return units.map(memory, ProcMem::getShare, 0L) / ONE_MEGABYTE;
  }
}
