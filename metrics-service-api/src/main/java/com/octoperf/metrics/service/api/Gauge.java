package com.octoperf.metrics.service.api;

@FunctionalInterface
public interface Gauge {

  double getValue();
}
