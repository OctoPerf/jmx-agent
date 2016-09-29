package com.octoperf.metrics.api;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

import static org.springframework.jmx.support.MetricType.COUNTER;

@ManagedResource
public interface ProcessMetrics {

  @ManagedAttribute(description = "Process name.")
  String getName();

  @ManagedAttribute(description = "Process PID.")
  long getPid();

  @ManagedMetric
  double getPercentCpuUsage();

  @ManagedMetric(metricType = COUNTER)
  long getUserCpuTimeSec();

  @ManagedMetric(metricType = COUNTER)
  long getSysCpuTimeSec();

  @ManagedMetric(metricType = COUNTER)
  long getTotalCpuTimeSec();

  @ManagedMetric
  double getVirtualMemSizeMb();

  @ManagedMetric
  double getResidentMemSizeMb();

  @ManagedMetric
  double getShareMemSizeMb();
}
