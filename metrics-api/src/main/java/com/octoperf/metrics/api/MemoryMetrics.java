package com.octoperf.metrics.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(value = "Sigar:type=Memory")
public interface MemoryMetrics {

  @ManagedMetric
  long getTotal();

  @ManagedMetric
  long getRam();

  @ManagedMetric
  long getUsed();

  @ManagedMetric
  long getFree();

  @ManagedMetric
  long getActualFree();

  @ManagedMetric
  long getActualUsed();

  @ManagedMetric
  double getFreePercent();

  @ManagedMetric
  double getUsedPercent();
}
