package com.octoperf.metrics.service.spring;

import com.octoperf.metrics.service.api.Gauge;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.atomic.AtomicReference;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class SubstractingGauge implements Gauge {
  @NonNull
  Gauge source;
  AtomicReference<Double> previous = new AtomicReference<>();

  @Override
  public synchronized double getValue() {
    final double value = source.getValue();
    if(previous.compareAndSet(null, value)) {
      return 0d;
    }

    final double previous = this.previous.getAndSet(value);
    return value - previous;
  }
}
