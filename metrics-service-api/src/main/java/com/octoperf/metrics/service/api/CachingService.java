package com.octoperf.metrics.service.api;

import javaslang.control.Try;

public interface CachingService {

  <R> Try.CheckedSupplier<R> cache(Try.CheckedSupplier<R> func);
}
