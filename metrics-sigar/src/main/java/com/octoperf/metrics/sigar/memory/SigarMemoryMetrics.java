package com.octoperf.metrics.sigar.memory;

import com.octoperf.metrics.api.MemoryMetrics;
import com.octoperf.metrics.condition.IsNotWindows;
import com.octoperf.metrics.service.api.UnitConversionService;
import javaslang.control.Try;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.Mem;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static com.octoperf.metrics.utils.DataUnitIEC.UNIT;

@Component
@Conditional(IsNotWindows.class)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class SigarMemoryMetrics implements MemoryMetrics {
  @NonNull
  Try.CheckedSupplier<Mem> mem;
  @NonNull
  UnitConversionService units;

  @Override
  public long getTotal() {
    return map(Mem::getTotal);
  }

  @Override
  public long getRam() {
    return map(Mem::getRam);
  }

  @Override
  public long getUsed() {
    return map(Mem::getUsed);
  }

  @Override
  public long getFree() {
    return map(Mem::getFree);
  }

  @Override
  public long getActualFree() {
    return map(Mem::getActualFree);
  }

  @Override
  public long getActualUsed() {
    return map(Mem::getActualUsed);
  }

  private long map(final Function<Mem, Long> func) {
    return units.map(mem, func.andThen(UNIT::toMebis), 0L);
  }

  @Override
  public double getFreePercent() {
    return units.map(mem, Mem::getFreePercent, 0d);
  }

  @Override
  public double getUsedPercent() {
    return units.map(mem, Mem::getUsedPercent, 0d);
  }
}
