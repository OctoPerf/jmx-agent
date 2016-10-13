package com.octoperf.metrics.iis.api.web.service;


import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(
  description = "Miscellaneous counters for the Web Service performance object.")
public interface WebServiceMiscMetrics {

  @ManagedAttribute(description = "Website name.")
  String getInstance();

  @ManagedMetric(
    displayName = "Service Uptime",
    description = "The uptime for the WWW service or a Web site",
    unit = "seconds")
  double getServiceUptime();

}
