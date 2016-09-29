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
final class PerSecondGauge implements Gauge {
  @NonNull
  Gauge source;
  AtomicReference<Long> timestamp = new AtomicReference<>();

  @Override
  public synchronized double getValue() {
    final long now = System.currentTimeMillis();
    if(timestamp.compareAndSet(null, now)) {
      return 0d;
    }

    final double value = source.getValue();
    final double seconds = (now - timestamp.getAndSet(now)) / 1000d;
    return seconds > 0d ? value / seconds : 0d;
  }
}
