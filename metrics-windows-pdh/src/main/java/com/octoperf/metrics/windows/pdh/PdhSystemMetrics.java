package com.octoperf.metrics.windows.pdh;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import com.octoperf.metrics.windows.pdh.api.WindowsSystemMetrics;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.win32.Pdh;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.octoperf.metrics.windows.pdh.PdhProcessors.PROCESSOR;

@Component
@ConditionalOnBean(Pdh.class)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhSystemMetrics implements WindowsSystemMetrics {
  public static final String SYSTEM = "System";
  private static final Set<String> FORMATTED = ImmutableSet.of(
      "% Registry Quota In Use",
      "System Up Time"
  );

  double cpuCount;
  PerfmonQueryService perfmon;
  GaugeService gauges;

  PdhSystemMetrics(final PerfmonQueryService perfmon, final GaugeService gauges) {
    super();
    this.cpuCount = perfmon.getInstances(PROCESSOR).size() - 1d;
    this.perfmon = checkNotNull(perfmon);
    this.gauges = checkNotNull(gauges);
  }

  @Override
  public double getProcessorCount() {
    return cpuCount;
  }

  @Override
  public double getProcessorQueueLength() {
    return raw("Processor Queue Length");
  }

  @Override
  public double getProcessorQueueLengthPerCPU() {
    return getProcessorQueueLength() / cpuCount;
  }

  @Override
  public double getContextSwitchesPerSec() {
    return perSecond("Context Switches/sec");
  }

  @Override
  public double getFileReadOperationsPerSec() {
    return perSecond("File Read Operations/sec");
  }

  @Override
  public double getFileWriteOperationsPerSec() {
    return perSecond("File Write Operations/sec");
  }

  @Override
  public double getFileControlOperationsPerSec() {
    return perSecond("File Control Operations/sec");
  }

  @Override
  public double getFileReadBytesPerSec() {
    return perSecond("File Read Bytes/sec");
  }

  @Override
  public double getFileWriteBytesPerSec() {
    return perSecond("File Write Bytes/sec");
  }

  @Override
  public double getFileControlBytesPerSec() {
    return perSecond("File Control Bytes/sec");
  }

  @Override
  public double getSystemCallsPerSec() {
    return perSecond("System Calls/sec");
  }

  @Override
  public double getFileDataOperationsPerSec() {
    return perSecond("File Data Operations/sec");
  }

  @Override
  public double getSystemUpTime() {
    return formatted("System Up Time");
  }

  @Override
  public double getProcesses() {
    return raw("Processes");
  }

  @Override
  public double getThreads() {
    return raw("Threads");
  }

  @Override
  public double getAlignmentFixupsPerSec() {
    return perSecond("Alignment Fixups/sec");
  }

  @Override
  public double getExceptionDispatchesPerSec() {
    return perSecond("Exception Dispatches/sec");
  }

  @Override
  public double getFloatingEmulationsPerSec() {
    return perSecond("Floating Emulations/sec");
  }

  @Override
  public double getPercentRegistryQuotaInUse() {
    return formatted("% Registry Quota In Use");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> raw(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double raw(final String counter) {
    return perfmon.getRawValue(SYSTEM, counter);
  }

  private double formatted(final String counter) {
    return perfmon
        .getFormattedValues(SYSTEM, FORMATTED)
        .get(counter);
  }
}
