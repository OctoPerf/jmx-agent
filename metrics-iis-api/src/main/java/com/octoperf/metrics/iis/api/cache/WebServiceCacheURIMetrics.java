package com.octoperf.metrics.iis.api.cache;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "IIS:type=WebServiceCache,category=URI",
  description = "Web Service Cache URI metrics.")
public interface WebServiceCacheURIMetrics {

  @ManagedMetric(
    displayName = "Current URIs Cached",
    description = "The number of URI information blocks that are currently stored in the user-mode cache.",
    unit = "uris")
  double getCurrentURIsCached();

  @ManagedMetric(
    displayName = "Total URIs Cached",
    description = "The number of URI information blocks that have been added to the user-mode cache since the WWW service started.",
    unit = "uris")
  double getTotalURIsCached();

  @ManagedMetric(
    displayName = "URI Cache Hits",
    description = "The number of successful lookups that have been made in the user-mode URI cache since the WWW service started.",
    unit = "hits")
  double getURICacheHits();

  @ManagedMetric(
    displayName = "URI Cache Misses",
    description = "The number of unsuccessful lookups that have been made in the user-mode URI cache since the WWW service started.",
    unit = "misses")
  double getURICacheMisses();

  @ManagedMetric(
    displayName = "URI Cache Hits %",
    description = "The ratio of URI Cache Hits to total cache requests that have occurred since the WWW service started.",
    unit = "%")
  double getPercentURICacheHits();

  @ManagedMetric(
    displayName = "URI Cache Flushes",
    description = "The total number of URI cache flushes that have occurred since the WWW service started.",
    unit = "flushes")
  double getURICacheFlushes();

  @ManagedMetric(
    displayName = "Total Flushed URIs",
    description = "The number of URI information blocks that have been removed from the user-mode cache since the WWW service started.",
    unit = "flushes")
  double getTotalFlushedURIs();
}
