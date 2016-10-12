package com.octoperf.metrics.iis.api.global;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * Internet Information Services Global
 */
@ManagedResource(
  objectName = "IIS:type=GlobalCache,category=File",
  description = "File Cache counters for the Internet Information Services Global performance object.")
public interface IISGlobalFileCacheMetrics {

  @ManagedMetric(
    displayName = "Current Files Cached",
    description = "The number of files whose content is currently in the cache.",
    unit = "files")
  double getCurrentFilesCached();

  @ManagedMetric(
    displayName = "Total Files Cached",
    description = "The number of files whose content has been added to the cache since the service started.",
    unit = "files")
  double getTotalFilesCached();

  @ManagedMetric(
    displayName = "File Cache Hits",
    description = "The number of successful lookups in the file cache.",
    unit = "hits")
  double getFileCacheHits();

  @ManagedMetric(
    displayName = "File Cache Misses",
    description = "The number of unsuccessful lookups in the file cache.",
    unit = "misses")
  double getFileCacheMisses();

  @ManagedMetric(
    displayName = "File Cache Hits %",
    description = "The ratio of File Cache Hits to the total number of cache requests.",
    unit = "%")
  double getFileCacheHitsPercent();

  @ManagedMetric(
    displayName = "File Cache Flushes",
    description = "The number of file cache flushes that have occurred since the service started.",
    unit = "flushes")
  double getFileCacheFlushes();

  @ManagedMetric(
    displayName = "Current File Cache Memory Usage",
    description = "The current number of bytes used for the file cache.",
    unit = "Bytes")
  double getCurrentFileCacheMemoryUsage();

  @ManagedMetric(
    displayName = "Maximum File Cache Memory Usage",
    description = "The maximum number of bytes used for the file cache.",
    unit = "bytes")
  double getMaximumFileCacheMemoryUsage();
}
