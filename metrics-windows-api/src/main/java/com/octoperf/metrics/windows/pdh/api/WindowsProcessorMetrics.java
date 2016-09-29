package com.octoperf.metrics.windows.pdh.api;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource("Windows:type=Processor")
public interface WindowsProcessorMetrics {

  @ManagedAttribute(description = "Processor Instance.")
  String getInstance();

  @ManagedMetric(
    displayName = "% Processor Time",
    unit = "%",
    description="% Processor Time")
  double getPercentProcessorTime();

  @ManagedMetric(
    displayName = "% Idle Time",
    unit = "%",
    description="The percentage of time a process was running in idle mode.")
  double getPercentCpuIdleTime();

  @ManagedMetric(
    displayName = "Interrupts/sec",
    unit = "interrupts/sec",
    description="The average rate per second at which the processor handles " +
    "interrupts from applications or hardware devices.")
  double getInterruptsPerSec();

  @ManagedMetric(
    displayName = "% Privileged Time",
    unit = "%",
    description="The percentage of time a process was running in privileged mode.")
  double getPercentCpuPrivilegedTime();

  @ManagedMetric(
    displayName = "% User Time",
    unit = "%",
    description="The percentage of time a process was running in user mode.")
  double getPercentCpuUserTime();

  @ManagedMetric(
    displayName = "% Interrupt Time",
    unit = "%",
    description = " This measures the time the processor spends receiving and " +
    "servicing hardware interruptions during specific sample intervals.")
  double getPercentCpuInterruptTime();

  @ManagedMetric(
    displayName = "DPC Queued/sec",
    unit = "dpc/sec",
    description = "DPCs (Deferred Procedure Calls) Queued per Second measures " +
    "the rate at which DPC objects are added to the processor's DPC queue.")
  double getDPCQueuedPerSec();

  @ManagedMetric(
    displayName = "% DPC Time",
    unit = "%",
    description = "% of time spent in DPCs (Deferred Procedure Calls).")
  double getPercentDPCTime();

  @ManagedMetric(
    displayName = "DPC Rate",
    unit = "dpc/sec",
    description = "DPCs (Deferred Procedure Calls) Rate.")
  double getDPCRate();

  @ManagedMetric(
    displayName = "% C1 Time",
    unit = "%",
    description = "% of Processor time spent in C1 state.")
  double getPercentC1Time();

  @ManagedMetric(
    displayName = "% C2 Time",
    unit = "%",
    description = "% of Processor time spent in C2 state.")
  double getPercentC2Time();

  @ManagedMetric(
    displayName = "% C3 Time",
    unit = "%",
    description = "% of Processor time spent in C3 state.")
  double getPercentC3Time();

  @ManagedMetric(
    displayName = "C1 transitions/sec",
    unit = "transitions/sec",
    description = "Number of Processor to C1 state transitions per second.")
  double getC1TransitionsPerSec();

  @ManagedMetric(
    displayName = "C2 transitions/sec",
    unit = "transitions/sec",
    description = "Number of Processor to C2 state transitions per second.")
  double getC2TransitionsPerSec();

  @ManagedMetric(
    displayName = "C2 transitions/sec",
    unit = "transitions/sec",
    description = "Number of Processor to C3 state transitions per second.")
  double getC3TransitionsPerSec();
}
