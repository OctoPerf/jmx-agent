package com.octoperf.metrics.sigar.memory;

import com.octoperf.metrics.service.api.CachingService;
import com.octoperf.metrics.condition.IsNotWindows;
import javaslang.control.Try;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(IsNotWindows.class)
class MemoryConfig {

  @Bean
  Try.CheckedSupplier<Mem> memory(
    final Sigar sigar,
    final CachingService caching) {
    return caching.cache(sigar::getMem);
  }
}
