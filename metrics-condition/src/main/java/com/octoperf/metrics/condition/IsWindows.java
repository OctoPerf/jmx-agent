package com.octoperf.metrics.condition;

import org.hyperic.sigar.OperatingSystem;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public final class IsWindows implements Condition {
 
  @Override 
  public boolean matches(final ConditionContext context, final AnnotatedTypeMetadata metadata) {
    return OperatingSystem.IS_WIN32;
  }
}