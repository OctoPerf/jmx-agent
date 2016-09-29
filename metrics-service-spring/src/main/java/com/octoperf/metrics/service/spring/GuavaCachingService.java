package com.octoperf.metrics.service.spring;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.octoperf.metrics.service.api.CachingService;
import javaslang.control.Try;
import org.springframework.stereotype.Service;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
final class GuavaCachingService implements CachingService {
  private static final String KEY = "";

  @Override
  public <R> Try.CheckedSupplier<R> cache(final Try.CheckedSupplier<R> func) {
    final LoadingCache<String, R> cache = CacheBuilder
      .newBuilder()
      .expireAfterWrite(5, SECONDS)
      .build(new CacheLoader<String, R>() {
        @Override
        public R load(final String key) throws Exception {
          try {
            return func.get();
          } catch (final Throwable t) {
            throw new RuntimeException(t);
          }
        }
      });
    return () -> cache.getUnchecked(KEY);
  }
}
