package com.octoperf.metrics.iis.api.cache;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "IIS:type=WebServiceCache,category=Metadata",
  description = "Web Service Cache Metadata metrics.")
public interface WebServiceCacheMetadataMetrics {

  @ManagedMetric(
    displayName = "Current Metadata Cached",
    description = "The number of Metadata information blocks that are currently stored in the user-mode cache.",
    unit = "Metadatas")
  double getCurrentMetadataCached();

  @ManagedMetric(
    displayName = "Total Metadata Cached",
    description = "The number of Metadata information blocks that have been added to the user-mode cache since the WWW service started.",
    unit = "Metadatas")
  double getTotalMetadataCached();

  @ManagedMetric(
    displayName = "Metadata Cache Hits",
    description = "The number of successful lookups that have been made in the user-mode Metadata cache since the WWW service started.",
    unit = "hits")
  double getMetadataCacheHits();

  @ManagedMetric(
    displayName = "Metadata Cache Misses",
    description = "The number of unsuccessful lookups that have been made in the user-mode Metadata cache since the WWW service started.",
    unit = "misses")
  double getMetadataCacheMisses();

  @ManagedMetric(
    displayName = "Metadata Cache Hits %",
    description = "The ratio of Metadata Cache Hits to total cache requests that have occurred since the WWW service started.",
    unit = "%")
  double getPercentMetadataCacheHits();

  @ManagedMetric(
    displayName = "Metadata Cache Flushes",
    description = "The total number of Metadata cache flushes that have occurred since the WWW service started.",
    unit = "flushes")
  double getMetadataCacheFlushes();

  @ManagedMetric(
    displayName = "Total Flushed Metadata",
    description = "The number of Metadata information blocks that have been removed from the user-mode cache since the WWW service started.",
    unit = "flushes")
  double getTotalFlushedMetadata();
}
