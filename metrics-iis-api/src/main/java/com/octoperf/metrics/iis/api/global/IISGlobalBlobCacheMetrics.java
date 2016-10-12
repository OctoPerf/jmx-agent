package com.octoperf.metrics.iis.api.global;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * Internet Information Services Global.
 */
@ManagedResource(
  objectName = "IIS:type=GlobalCache,category=Blob",
  description = "Flushed and BLOB Cached counters for the Internet Information Services Global performance object.")
public interface IISGlobalBlobCacheMetrics {

  @ManagedMetric(
    displayName = "Current BLOBs Cached",
    description = " The number of cached file handles that will close when all current transfers are complete.",
    unit = "blobs")
  double getCurrentBLOBsCached();

  @ManagedMetric(
    displayName = "Total BLOBs Cached",
    description = "The number of BLOB information blocks that have been added to the cache.",
    unit = "blobs")
  double getTotalBLOBsCached();

  @ManagedMetric(
    displayName = "BLOB Cache Hits",
    description = "The number of successful lookups in the BLOB cache.",
    unit = "hits")
  double getBLOBCacheHits();

  @ManagedMetric(
    displayName = "BLOB Cache Misses",
    description = "The number of unsuccessful lookups in the BLOB cache.",
    unit = "misses")
  double getBLOBCacheMisses();

  @ManagedMetric(
    displayName = "BLOB Cache Flushes",
    description = "The number of BLOB cache flushes that have occurred since the service started.",
    unit = "flushes")
  double getBLOBCacheFlushes();

  @ManagedMetric(
    displayName = "BLOB Cache Hits %",
    description = "The ratio of BLOB Cache Hits to the total number of cache requests.",
    unit = "%")
  double getBLOBCacheHitsPercent();

  @ManagedMetric(
    displayName = "Total Flushed BLOBs",
    description = "The number of BLOB information blocks that have been removed from the cache since the service started.\n",
    unit = "blobs")
  double getTotalFlushedBLOBs();

}
