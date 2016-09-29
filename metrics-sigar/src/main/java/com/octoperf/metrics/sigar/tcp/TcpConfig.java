package com.octoperf.metrics.sigar.tcp;

import com.octoperf.metrics.service.api.CachingService;
import com.octoperf.metrics.condition.IsNotWindows;
import javaslang.control.Try;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.Tcp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(IsNotWindows.class)
class TcpConfig {

  @Bean
  Try.CheckedSupplier<Tcp> tcp(
    final Sigar sigar,
    final CachingService caching) {
    return caching.cache(sigar::getTcp);
  }
}
