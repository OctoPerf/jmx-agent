package com.octoperf.metrics.windows.pdh;

import com.octoperf.metrics.condition.IsWindows;
import kamon.sigar.SigarProvisioner;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.win32.Pdh;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.io.File;

@Configuration
@Conditional(IsWindows.class)
class PdhConfig {
  @Bean
  @DependsOn("sigar")
  Pdh pdh() throws Exception {
    return new Pdh();
  }
}
