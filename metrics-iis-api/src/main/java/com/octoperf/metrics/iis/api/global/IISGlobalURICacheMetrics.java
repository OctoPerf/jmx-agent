package com.octoperf.metrics.iis.api.global;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * Internet Information Services Global.
 */
@ManagedResource(
  objectName = "IIS:type=GlobalCache,category=URI",
  description = "Flushed and URI Cached counters for the Internet Information Services Global performance object.")
public interface IISGlobalURICacheMetrics {

  @ManagedMetric(
    displayName = "Active Flushed Entries",
    description = " The number of cached file handles that will close when all current transfers are complete.",
    unit = "entries")
  double getActiveFlushedEntries();

  @ManagedMetric(
    displayName = "Total Flushed Files",
    description = "The number of file handles that have been removed from the cache since the service started.",
    unit = "files")
  double getTotalFlushedFiles();

  @ManagedMetric(
    displayName = "Current URIs Cached",
    description = "The number of URI information blocks that are currently in the cache.",
    unit = "uris")
  double getCurrentURIsCached();

  @ManagedMetric(
    displayName = "Total URIs Cached",
    description = "The number of URI information blocks that have been added to the cache.",
    unit = "uris")
  double getTotalURIsCached();

  @ManagedMetric(
    displayName = "URI Cache Hits",
    description = "The number of successful lookups in the URI cache.",
    unit = "hits")
  double getURICacheHits();

  @ManagedMetric(
    displayName = "URI Cache Misses",
    description = "The number of unsuccessful lookups in the URI cache.",
    unit = "misses")
  double getURICacheMisses();

  @ManagedMetric(
    displayName = "URI Cache Hits %",
    description = "The ratio of URI Cache Hits to the total number of cache requests.",
    unit = "%")
  double getURICacheHitsPercent();

  @ManagedMetric(
    displayName = "URI Cache Flushes",
    description = "The number of URI cache flushes that have occurred since the server started.",
    unit = "flushes")
  double getURICacheFlushes();

  @ManagedMetric(
    displayName = "Total Flushed URIs",
    description = "The number of URI information blocks that have been removed from the cache since the service started.",
    unit = "uris")
  double getTotalFlushedURIs();

}
