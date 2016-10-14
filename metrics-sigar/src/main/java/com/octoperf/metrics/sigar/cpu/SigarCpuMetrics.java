package com.octoperf.metrics.sigar.cpu;

import com.octoperf.metrics.api.CpuMetrics;
import com.octoperf.metrics.condition.IsNotWindows;
import com.octoperf.metrics.service.api.UnitConversionService;
import javaslang.collection.List;
import javaslang.control.Try;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Conditional(IsNotWindows.class)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class SigarCpuMetrics implements CpuMetrics {
  private static final int ONE_MIN = 0;
  private static final int FIVE_MIN = 1;
  private static final int FIFHTEEN_MIN = 2;
  public static final long ONE_SECOND = 1000L;

  @NonNull
  UnitConversionService units;
  @NonNull
  Try.CheckedSupplier<Cpu> cpu;
  @NonNull
  Try.CheckedSupplier<CpuPerc> cpuPerc;
  @NonNull
  Try.CheckedSupplier<double[]> loadAverage;
  @NonNull
  Try.CheckedSupplier<CpuInfo[]> cpuInfo;

  @Override
  public long getTotalCpuUserTimeSec() {
    return units.map(cpu, Cpu::getUser, 0L) / ONE_SECOND;
  }

  @Override
  public long getTotalCpuSysTimeSec() {
    return units.map(cpu, Cpu::getSys, 0L) / ONE_SECOND;
  }

  @Override
  public long getTotalCpuTimeSec() {
    return units.map(cpu, Cpu::getTotal, 0L) / ONE_SECOND;
  }

  @Override
  public long getTotalIdleCpuTimeSec() {
    return units.map(cpu, Cpu::getIdle, 0L) / ONE_SECOND;
  }

  @Override
  public long getTotalIrqCpuTimeSec() {
    return units.map(cpu, Cpu::getIrq, 0L) / ONE_SECOND;
  }

  @Override
  public long getTotalNiceCpuTimeSec() {
    return units.map(cpu, Cpu::getNice, 0L) / ONE_SECOND;
  }

  @Override
  public long getTotalSoftIrqCpuTimeSec() {
    return units.map(cpu, Cpu::getSoftIrq, 0L) / ONE_SECOND;
  }

  @Override
  public long getTotalStolenCpuTimeSec() {
    return units.map(cpu, Cpu::getStolen, 0L) / ONE_SECOND;
  }

  @Override
  public long getTotalWaitCpuTimeSec() {
    return units.map(cpu, Cpu::getWait, 0L) / ONE_SECOND;
  }

  @Override
  public int getTotalCpuCores() {
    return compute(CpuInfo::getTotalCores);
  }

  @Override
  public int getTotalCpuSockets() {
    return compute(CpuInfo::getTotalSockets);
  }

  private int compute(final Function<CpuInfo, Integer> func) {
    return Try.of(cpuInfo)
      .map(List::of)
      .map(List::head)
      .map(func)
      .getOrElse(0);
  }

  @Override
  public double getPercentCpuCombined() {
    return toPercent(CpuPerc::getCombined);
  }

  @Override
  public double getPercentCpuIrq() {
    return toPercent(CpuPerc::getIrq);
  }

  @Override
  public double getPercentCpuSoftIrq() {
    return toPercent(CpuPerc::getSoftIrq);
  }

  @Override
  public double getPercentCpuIdle() {
    return toPercent(CpuPerc::getIdle);
  }

  @Override
  public double getPercentCpuWait() {
    return toPercent(CpuPerc::getWait);
  }

  @Override
  public double getPercentCpuStolen() {
    return toPercent(CpuPerc::getStolen);
  }

  @Override
  public double getPercentCpuSys() {
    return toPercent(CpuPerc::getSys);
  }

  @Override
  public double getPercentCpuUser() {
    return toPercent(CpuPerc::getUser);
  }

  @Override
  public double getPercentCpuNice() {
    return toPercent(CpuPerc::getNice);
  }

  @Override
  public double getLoadAverage1min() {
    return loadAverage(ONE_MIN);
  }

  @Override
  public double getLoadAverage5min() {
    return loadAverage(FIVE_MIN);
  }

  @Override
  public double getLoadAverage15min() {
    return loadAverage(FIFHTEEN_MIN);
  }

  private double loadAverage(final int index) {
    return Try.of(loadAverage).map(la -> la[index]).getOrElse(0d);
  }

  private double toPercent(final Function<CpuPerc, Double> func) {
    return units.map(cpuPerc, func, 0d) * 100d;
  }
}
