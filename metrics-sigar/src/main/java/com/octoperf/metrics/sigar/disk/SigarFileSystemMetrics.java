package com.octoperf.metrics.sigar.disk;

import com.octoperf.metrics.api.FileSystemMetrics;
import com.octoperf.metrics.service.api.UnitConversionService;
import javaslang.control.Try;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.FileSystemUsage;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import static com.octoperf.metrics.utils.DataUnitIEC.KIBIS;
import static com.octoperf.metrics.utils.DataUnitIEC.UNIT;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SigarFileSystemMetrics implements FileSystemMetrics {
  @NonNull
  UnitConversionService units;
  @NonNull
  Try.CheckedSupplier<FileSystemUsage> usage;
  @Getter
  @NonNull
  String dirName;
  @Getter
  @NonNull
  String devName;
  @Getter
  @NonNull
  String sysTypeName;
  @Getter
  @NonNull
  String options;

  @Override
  public long getTotal() {
    return convert(FileSystemUsage::getTotal, KIBIS::toMebis);
  }

  @Override
  public long getUsed() {
    return convert(FileSystemUsage::getUsed, KIBIS::toMebis);
  }

  @Override
  public long getFree() {
    return convert(FileSystemUsage::getFree, KIBIS::toMebis);
  }

  @Override
  public double getDiskQueue() {
    return units.map(usage, FileSystemUsage::getDiskQueue, 0d);
  }

  @Override
  public long getDiskReadMegaBytes() {
    return convert(FileSystemUsage::getDiskReadBytes, UNIT::toMebis);
  }

  @Override
  public long getDiskWriteMegaBytes() {
    return convert(FileSystemUsage::getDiskWriteBytes, UNIT::toMebis);
  }

  private long convert(final Function<FileSystemUsage, Long> func, final UnaryOperator<Long> toUnit) {
    return units.map(usage, func.andThen(toUnit), 0L);
  }

  @Override
  public double getDiskServiceTime() {
    return units.map(usage, FileSystemUsage::getDiskServiceTime, 0d);
  }

  @Override
  public long getDiskReads() {
    return units.map(usage, FileSystemUsage::getDiskReads, 0L);
  }

  @Override
  public long getDiskWrites() {
    return units.map(usage, FileSystemUsage::getDiskWrites, 0L);
  }

  @Override
  public double getUsedPercent() {
    return units.map(usage, FileSystemUsage::getUsePercent, 0d) * 100d;
  }
}
