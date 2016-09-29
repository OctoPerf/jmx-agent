package com.octoperf.metrics.service.spring;

import com.octoperf.metrics.service.api.UnitConversionService;
import javaslang.control.Try;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
final class SpringConversionService implements UnitConversionService {

  @Override
  public <N extends Number, T> N map(
    final Try.CheckedSupplier<T> supplier,
    final Function<T, N> func,
    final N defaultValue) {
    return Try.of(supplier).map(func).getOrElse(defaultValue);
  }
}
