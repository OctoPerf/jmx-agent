package com.octoperf.metrics.sqlserver.pdh;

import kamon.sigar.SigarProvisioner;
import org.hyperic.sigar.win32.Pdh;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public final class IsSqlServer implements Condition {
  static final String SQL_SERVER = "SQLServer";
  static final String IS_SQL_SERVER = "is.sql.server";

  @Override
  public boolean matches(final ConditionContext context, final AnnotatedTypeMetadata metadata) {
    try {
      SigarProvisioner.provision();
      final String[] dbs = Pdh.getInstances(SQL_SERVER + ":Databases");
      return dbs.length > 0;
    } catch (final Exception e) {
      return false;
    }
  }
}