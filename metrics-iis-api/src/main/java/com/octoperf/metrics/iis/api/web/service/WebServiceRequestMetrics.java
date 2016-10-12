package com.octoperf.metrics.iis.api.web.service;


import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Requests counters for the Web Service performance object.")
public interface WebServiceRequestMetrics {

  @ManagedAttribute(description = "Website name.")
  String getInstance();

  @ManagedMetric(
    displayName = "Total Options Requests",
    description = "The number of HTTP requests that have used the OPTIONS method since the WWW service started.",
    unit = "requests"
  )
  double getTotalOptionsRequests();

  @ManagedMetric(
    displayName = "Options Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the OPTIONS method have been made.",
    unit = "requests/sec"
  )
  double getOptionsRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Get Requests",
    description = "The number of HTTP requests that have used the GET method since the WWW service started.",
    unit = "requests"
  )
  double getTotalGetRequests();

  @ManagedMetric(
    displayName = "Get Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the GET method have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getGetRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Post Requests",
    description = "The number of HTTP requests that have used the POST method since the WWW service started.",
    unit = "requests"
  )
  double getTotalPostRequests();

  @ManagedMetric(
    displayName = "Post Requests/sec",
    description = "The rate, in seconds, at which requests that use the POST method have been made to the WWW service.",
    unit = "requests/Sec"
  )
  double getPostRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Head Requests",
    description = "The number of HTTP requests that have used the HEAD method since the WWW service started.",
    unit = "requests"
  )
  double getTotalHeadRequests();

  @ManagedMetric(
    displayName = "Head Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the HEAD method have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getHeadRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Put Requests",
    description = "The number of HTTP requests that have used the PUT method since the WWW service started.",
    unit = "requests"
  )
  double getTotalPutRequests();

  @ManagedMetric(
    displayName = "Put Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the PUT method have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getPutRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Delete Requests",
    description = "The number of HTTP requests that have used the DELETE method since the WWW service started.",
    unit = "requests"
  )
  double getTotalDeleteRequests();

  @ManagedMetric(
    displayName = "Delete Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the DELETE method have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getDeleteRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Trace Requests",
    description = "The number of HTTP requests that have used the TRACE method since the WWW service started.",
    unit = "requests"
  )
  double getTotalTraceRequests();

  @ManagedMetric(
    displayName = "Trace Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the TRACE method have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getTraceRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Move Requests",
    description = "The number of HTTP requests that have used the MOVE method since the WWW service started.",
    unit = "requests"
  )
  double getTotalMoveRequests();

  @ManagedMetric(
    displayName = "Move Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the MOVE method have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getMoveRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Copy Requests",
    description = "The number of HTTP requests that have used the COPY method since the WWW service started.",
    unit = "requests"
  )
  double getTotalCopyRequests();

  @ManagedMetric(
    displayName = "Copy Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the COPY method have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getCopyRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Mkcol Requests",
    description = "The number of HTTP requests that have used the MKCOL method since the WWW service started.",
    unit = "requests"
  )
  double getTotalMkcolRequests();

  @ManagedMetric(
    displayName = "Mkcol Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the MKCOL method have been made to the WWW service.",
    unit = "requests"
  )
  double getMkcolRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Propfind Requests",
    description = "The number of HTTP requests that have used the PROPFIND method since the WWW service started.",
    unit = "requests"
  )
  double getTotalPropfindRequests();

  @ManagedMetric(
    displayName = "Propfind Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the PROPFIND method have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getPropfindRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Proppatch Requests",
    description = "The number of HTTP requests that have used the PROPPATCH method since the WWW service started.",
    unit = "requests"
  )
  double getTotalProppatchRequests();

  @ManagedMetric(
    displayName = "Proppatch Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the PROPPATCH method have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getProppatchRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Search Requests",
    description = "The number of HTTP requests that have used the SEARCH method since the WWW service started.",
    unit = "requests"
  )
  double getTotalSearchRequests();

  @ManagedMetric(
    displayName = "Search Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the SEARCH method have been made to the WWW service.",
    unit = "requests"
  )
  double getSearchRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Lock Requests",
    description = "The number of HTTP requests that have used the LOCK method since the WWW service started.",
    unit = "requests"
  )
  double getTotalLockRequests();

  @ManagedMetric(
    displayName = "Lock Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the LOCK method have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getLockRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Unlock Requests",
    description = "The number of HTTP requests that have used the UNLOCK method since the WWW service started.",
    unit = "requests"
  )
  double getTotalUnlockRequests();

  @ManagedMetric(
    displayName = "Unlock Requests/sec",
    description = "The rate, in seconds, at which HTTP requests that use the UNLOCK method have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getUnlockRequestsPerSec();

  @ManagedMetric(
    displayName = "Total Other Request Methods",
    description = "The number of HTTP requests that did not use the OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, MOVE, COPY, MKCOL, PROPFIND, PROPPATCH, SEARCH, LOCK, or UNLOCK methods since the WWW service started. Can include LINK or other methods supported by gateway applications.",
    unit = "requests"
  )
  double getTotalOtherRequestMethods();

  @ManagedMetric(
    displayName = "Other Request Methods/sec",
    description = "The rate, in seconds, at which HTTP requests that do not use the methods listed for the Total Other Requests Methods counter have been made to the WWW service.",
    unit = "requests/sec"
  )
  double getOtherRequestMethodsPerSec();

  @ManagedMetric(
    displayName = "Total Method Requests",
    description = "The number of HTTP requests that have been made since the WWW service started.",
    unit = "requests"
  )
  double getTotalMethodRequests();

  @ManagedMetric(
    displayName = "Total Method Requests/sec",
    description = "The rate, in seconds, at which all HTTP requests have been received.",
    unit = "requests"
  )
  double getTotalMethodRequestsPerSec();

}
