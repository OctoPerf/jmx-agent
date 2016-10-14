package com.octoperf.metrics.iis.pdh;

import kamon.sigar.SigarProvisioner;
import org.hyperic.sigar.win32.Pdh;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public final class IsIIS implements Condition {
  @Override
  public boolean matches(final ConditionContext context, final AnnotatedTypeMetadata metadata) {
    try {
      if(!SigarProvisioner.isNativeLoaded()) {
        SigarProvisioner.provision();
      }
      final String[] instances = Pdh.getInstances("Web Service");
      return instances.length > 0;
    } catch (final Exception e) {
      return false;
    }
  }
}