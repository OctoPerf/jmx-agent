package com.octoperf.metrics.iis.api;


import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  objectName = "IIS:type=Kernel",
  description = "Kernel counters reflect all HTTP.sys activity, not just IIS activity.")
public interface KernelURIMetrics {

  @ManagedMetric(
    displayName = "Current URIs Cached",
    description = "The number of URI information blocks currently cached by the kernel.",
    unit = "uris")
  double getCurrentURIsCached();

  @ManagedMetric(
    displayName = "Total URIs Cached",
    description = "The number of URI information blocks that have been added to the kernel URI cache since the WWW service started.",
    unit = "uris")
  double getTotalURIsCached();

  @ManagedMetric(
    displayName = "URI Cache Hits",
    description = "The number of successful lookups in the kernel URI cache that have occurred since the WWW service started.",
    unit = "hits")
  double getURICacheHits();

  @ManagedMetric(
    displayName = "URI Cache Hits%",
    description = "The ratio of Kernel: URI Cache Hits to total cache requests since the WWW service started.",
    unit = "%")
  double getPercentURICacheHits();

  @ManagedMetric(
    displayName = "URI Cache Hits/sec",
    description = "The average number of kernel URI cache hits that are being made per second.",
    unit = "hits/sec")
  double getURICacheHitsPerSec();

  @ManagedMetric(
    displayName = "URI Cache Misses",
    description = "The number of unsuccessful lookups in the kernel URI cache that have occurred since the WWW service started.",
    unit = "misses")
  double getURICacheMisses();

  @ManagedMetric(
    displayName = "URI Cache Flushes",
    description = "The number of kernel URI cache flushes that have occurred since the WWW service started.",
    unit = "flushes")
  double getURICacheFlushes();

  @ManagedMetric(
    displayName = "Total Flushed URIs",
    description = "The number of URI information blocks that have been removed from the kernel cache since the WWW service started.",
    unit = "uris")
  double getTotalFlushedURIs();
}
