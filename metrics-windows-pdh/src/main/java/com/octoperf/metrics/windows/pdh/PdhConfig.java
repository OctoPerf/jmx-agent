package com.octoperf.metrics.windows.pdh;

import com.octoperf.metrics.condition.IsWindows;
import org.hyperic.sigar.win32.Pdh;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@Conditional(IsWindows.class)
class PdhConfig {
  @Bean
  @DependsOn("sigar")
  Pdh pdh() throws Exception {
    return new Pdh();
  }
}
