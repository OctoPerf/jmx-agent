package com.octoperf.metrics.service.api;

public interface GaugeService {

  Gauge perSecond(Gauge gauge);

  Gauge cached(String name, Gauge gauge);
}
