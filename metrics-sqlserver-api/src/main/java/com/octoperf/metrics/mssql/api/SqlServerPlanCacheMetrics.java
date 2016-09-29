package com.octoperf.metrics.mssql.api;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * Instances can be:_total (all instances in total), SQL Plans (cached query plans from ad-hoc Transact-SQL statements), Object
 * Plans (query plans for stored procedures, user-defined functions and triggers), Bound Trees (normalized trees for views,
 * rules, computed columns and check constraints), Extended stored procedures (number of these objects referenced in
 * cache), Temporary tables & table variables (number of temp tables and table variables referenced in cache).
 */
@ManagedResource
public interface SqlServerPlanCacheMetrics {

  @ManagedAttribute(description = "SQL Cache Manager instance.")
  String getInstance();

  @ManagedMetric(
    displayName = "Cache Hit Ratio",
    unit = "ratio",
    description = "Ratio between cache hits and lookups.")
    double getCacheHitRatio();

  @ManagedMetric(
    displayName = "Cache Hit Ratio Base",
    unit = "ratio",
    description = "For internal use only.")
  double getCacheHitRatioBase();

  @ManagedMetric(
    displayName = "Cache Object Counts",
    unit = "objects",
    description = "Number of objects in the cache.")
  double getCacheObjectCounts();

  @ManagedMetric(
    displayName = "Cache Pages",
    unit = "pages",
    description = "Number of 8-kilobyte (KB) pages used by cache objects.")
  double getCachePages();

  @ManagedMetric(
    displayName = "Cache Objects in use",
    unit = "objects",
    description = "Number of cache objects in use.")
  double getCacheObjectsInUse();
}
