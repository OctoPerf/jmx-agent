package com.octoperf.metrics.windows.pdh;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.windows.pdh.api.WindowsProcessorMetrics;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.Set;

import static java.lang.String.format;
import static lombok.AccessLevel.PACKAGE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhProcessorMetrics implements WindowsProcessorMetrics {
  private static final String PROCESSOR = "Processor(%s)";
  private static final Set<String> FORMATTED_COUNTERS = ImmutableSet.of(
      "% Processor Time",
      "% DPC Time",
      "% Idle Time",
      "% Privileged Time",
      "% User Time",
      "% Interrupt Time",
      "% C3 Time",
      "% Processor Time",
      "% C2 Time",
      "% C1 Time"
  );


  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;
  @NonNull
  @Getter
  String instance;

  @Override
  public double getPercentProcessorTime() {
    return formatted("% Processor Time");
  }

  @Override
  public double getInterruptsPerSec() {
    return perSecond("Interrupts/sec");
  }

  @Override
  public double getPercentCpuIdleTime() {
    return formatted("% Idle Time");
  }

  @Override
  public double getPercentCpuPrivilegedTime() {
    return formatted("% Privileged Time");
  }

  @Override
  public double getPercentCpuUserTime() {
    return formatted("% User Time");
  }

  @Override
  public double getPercentCpuInterruptTime() {
    return formatted("% Interrupt Time");
  }

  @Override
  public double getDPCQueuedPerSec() {
    return perSecond("DPCs Queued/sec");
  }

  @Override
  public double getPercentDPCTime() {
    return formatted("% DPC Time");
  }

  @Override
  public double getDPCRate() {
    return raw("DPC Rate");
  }

  @Override
  public double getPercentC1Time() {
    return formatted("% C1 Time");
  }

  @Override
  public double getPercentC2Time() {
    return formatted("% C2 Time");
  }

  @Override
  public double getPercentC3Time() {
    return formatted("% C3 Time");
  }

  @Override
  public double getC1TransitionsPerSec() {
    return perSecond("C1 Transitions/sec");
  }

  @Override
  public double getC2TransitionsPerSec() {
    return perSecond("C2 Transitions/sec");
  }

  @Override
  public double getC3TransitionsPerSec() {
    return perSecond("C3 Transitions/sec");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> raw(counter);
    return gauges.cached(instance + counter, gauges.perSecond(gauge)).getValue();
  }

  private double raw(final String counter) {
    return perfmon.getRawValue(format(PROCESSOR, instance), counter);
  }

  private double formatted(final String counter) {
    return perfmon
        .getFormattedValues(format(PROCESSOR, instance), FORMATTED_COUNTERS)
        .getOrDefault(counter, 0d);
  }
}
