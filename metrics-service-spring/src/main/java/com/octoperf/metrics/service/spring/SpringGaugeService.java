package com.octoperf.metrics.service.spring;

import com.google.common.collect.Maps;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
final class SpringGaugeService implements GaugeService {
  Map<String, Gauge> gauges = Maps.newConcurrentMap();

  @Override
  public Gauge perSecond(final Gauge gauge) {
    return new PerSecondGauge(new SubstractingGauge(gauge));
  }

  @Override
  public Gauge substracting(final Gauge gauge) {
    return new SubstractingGauge(gauge);
  }

  @Override
  public Gauge cached(final String name, final Gauge gauge) {
    return gauges.computeIfAbsent(name, key -> gauge);
  }
}
