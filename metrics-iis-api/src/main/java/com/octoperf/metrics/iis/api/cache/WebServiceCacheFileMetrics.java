package com.octoperf.metrics.iis.api.cache;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "IIS:type=WebServiceCache,category=File",
  description = "Web Service Cache File metrics.")
public interface WebServiceCacheFileMetrics {

  @ManagedMetric(
    displayName = "Active Flushed Entries",
    description = "The number of user-mode cache entries that have been flushed, " +
      "though memory is still allocated for these entries. " +
      "The allocated memory will be released after all current transfers complete.",
    unit = "entries")
  double getActiveFlushedEntries();

  @ManagedMetric(
    displayName = "Current File Cache Memory Usage",
    description = "The number of bytes currently used for the user-mode file cache.",
    unit = "Bytes")
  double getCurrentFileCacheMemoryUsage();

  @ManagedMetric(
    displayName = "Current Files Cached",
    description = "The number of files whose content is currently in the user-mode cache.",
    unit = "files")
  double getCurrentFilesCached();

  @ManagedMetric(
    displayName = "Total Files Cached",
    description = "The number of files whose content has been added to the user-mode cache since the WWW service started.",
    unit = "files")
  double getTotalFilesCached();

  @ManagedMetric(
    displayName = "File Cache Hits",
    description = "The number of successful lookups in the user-mode file cache that have occurred since the WWW service started.",
    unit = "hits")
  double getFileCacheHits();

  @ManagedMetric(
    displayName = "File Cache Hits %",
    description = "The ratio of user-mode file cache hits to total cache requests that have been made since the WWW service started up.",
    unit = "%")
  double getPercentFileCacheHits();

  @ManagedMetric(
    displayName = "File Cache Misses",
    description = "The number of unsuccessful lookups in the user-mode file cache that have been made since the WWW service started.",
    unit = "misses")
  double getFileCacheMisses();

  @ManagedMetric(
    displayName = "File Cache Flushes",
    description = "The number of files that have been removed from the user-mode cache since the WWW service started.",
    unit = "flushes")
  double getFileCacheFlushes();

  @ManagedMetric(
    displayName = "Maximum File Cache Memory Usage",
    description = "The maximum number of bytes that have been used for the user-mode file cache since the WWW service started.",
    unit = "Bytes")
  double getMaximumFileCacheMemoryUsage();

  @ManagedMetric(
    displayName = "Total Flushed Files",
    description = "The number of file handles that have been removed from the user-mode cache since the WWW service started.",
    unit = "files")
  double getTotalFlushedFiles();
}
