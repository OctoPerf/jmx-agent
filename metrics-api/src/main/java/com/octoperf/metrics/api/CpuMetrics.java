package com.octoperf.metrics.api;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource("Sigar:type=CPU")
public interface CpuMetrics {

  @ManagedMetric(description = "Total User CPU Time in seconds.")
  long getTotalCpuUserTimeSec();

  @ManagedMetric(description = "Total System CPU Time in seconds.")
  long getTotalCpuSysTimeSec();

  @ManagedMetric
  long getTotalCpuTimeSec();

  @ManagedMetric
  long getTotalIdleCpuTimeSec();

  @ManagedMetric
  long getTotalIrqCpuTimeSec();

  @ManagedMetric
  long getTotalNiceCpuTimeSec();

  @ManagedMetric
  long getTotalSoftIrqCpuTimeSec();

  @ManagedMetric
  long getTotalStolenCpuTimeSec();

  @ManagedMetric
  long getTotalWaitCpuTimeSec();

  @ManagedAttribute
  int getTotalCpuCores();

  @ManagedAttribute
  int getTotalCpuSockets();

  @ManagedMetric
  double getPercentCpuCombined();

  @ManagedMetric
  double getPercentCpuIrq();

  @ManagedMetric
  double getPercentCpuSoftIrq();

  @ManagedMetric
  double getPercentCpuIdle();

  @ManagedMetric
  double getPercentCpuWait();

  @ManagedMetric
  double getPercentCpuStolen();

  @ManagedMetric
  double getPercentCpuSys();

  @ManagedMetric
  double getPercentCpuUser();

  @ManagedMetric
  double getPercentCpuNice();

  @ManagedMetric
  double getLoadAverage1min();

  @ManagedMetric
  double getLoadAverage5min();

  @ManagedMetric
  double getLoadAverage15min();
}
