package com.octoperf.metrics.sigar.cpu;

import com.octoperf.metrics.condition.IsNotWindows;
import com.octoperf.metrics.service.api.CachingService;
import javaslang.control.Try;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(IsNotWindows.class)
class CpuConfig {

  @Bean
  Try.CheckedSupplier<Cpu> cpu(
    final Sigar sigar,
    final CachingService caching) {
    return caching.cache(sigar::getCpu);
  }

  @Bean
  Try.CheckedSupplier<CpuPerc> cpuPerc(
    final Sigar sigar,
    final CachingService caching) {
    return caching.cache(sigar::getCpuPerc);
  }

  @Bean
  Try.CheckedSupplier<CpuInfo[]> cpuInfo(
    final Sigar sigar,
    final CachingService caching) {
    return caching.cache(sigar::getCpuInfoList);
  }

  @Bean
  Try.CheckedSupplier<double[]> loadAverage(
    final Sigar sigar,
    final CachingService caching) {
    return caching.cache(sigar::getLoadAverage);
  }
}
