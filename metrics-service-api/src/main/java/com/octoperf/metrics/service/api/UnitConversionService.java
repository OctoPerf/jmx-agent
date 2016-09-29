package com.octoperf.metrics.service.api;

import javaslang.control.Try;

import java.util.function.Function;

public interface UnitConversionService {

  <N extends Number, T> N map(
    Try.CheckedSupplier<T> supplier,
    Function<T, N> func,
    final N defaultValue);
}
