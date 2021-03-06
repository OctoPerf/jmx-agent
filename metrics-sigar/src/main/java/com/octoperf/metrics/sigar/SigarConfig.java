package com.octoperf.metrics.sigar;

import kamon.sigar.SigarProvisioner;
import org.hyperic.sigar.Sigar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SigarConfig {

  @Bean
  Sigar sigar() throws Exception {
    if(!SigarProvisioner.isNativeLoaded()) {
      SigarProvisioner.provision();
    }
    return new Sigar();
  }
}
