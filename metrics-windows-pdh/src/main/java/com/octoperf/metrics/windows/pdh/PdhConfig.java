package com.octoperf.metrics.windows.pdh;

import com.octoperf.metrics.condition.IsWindows;
import kamon.sigar.SigarProvisioner;
import org.hyperic.sigar.win32.Pdh;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
@Conditional(IsWindows.class)
class PdhConfig {
  @Bean
  Pdh pdh() throws Exception {
    SigarProvisioner.provision();
    return new Pdh();
  }
}
