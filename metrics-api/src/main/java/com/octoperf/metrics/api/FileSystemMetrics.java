package com.octoperf.metrics.api;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

import static org.springframework.jmx.support.MetricType.COUNTER;

@ManagedResource
public interface FileSystemMetrics {

  @ManagedAttribute
  String getDevName();

  @ManagedAttribute
  String getDirName();

  @ManagedMetric
  long getTotal();

  @ManagedMetric
  long getUsed();

  @ManagedMetric
  long getFree();

  @ManagedMetric
  double getDiskQueue();

  @ManagedMetric(metricType = COUNTER)
  long getDiskReadMegaBytes();

  @ManagedMetric(metricType = COUNTER)
  long getDiskWriteMegaBytes();

  @ManagedAttribute
  double getDiskServiceTime();

  @ManagedMetric(metricType = COUNTER)
  long getDiskReads();

  @ManagedMetric(metricType = COUNTER)
  long getDiskWrites();

  @ManagedMetric
  double getUsedPercent();
}
