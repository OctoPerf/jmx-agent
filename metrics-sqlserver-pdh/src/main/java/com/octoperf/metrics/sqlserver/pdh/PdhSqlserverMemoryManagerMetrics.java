package com.octoperf.metrics.sqlserver.pdh;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.mssql.api.SqlServerMemoryManagerMetrics;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import static com.octoperf.metrics.sqlserver.pdh.IsSqlServer.SQL_SERVER;
import static lombok.AccessLevel.PACKAGE;

@Component
@Conditional({IsWindows.class, IsSqlServer.class})
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhSqlserverMemoryManagerMetrics implements SqlServerMemoryManagerMetrics {
  private static final String MEM_MANAGER = SQL_SERVER + ":Memory Manager";

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getGrantedWorkspaceMemoryKB() {
    return memManager("Granted Workspace Memory (KB)");
  }

  @Override
  public double getMaximumWorkspaceMemoryKB() {
    return memManager("Maximum Workspace Memory (KB)");
  }

  @Override
  public double getMemoryGrantsOutstanding() {
    return memManager("Memory Grants Outstanding");
  }

  @Override
  public double getMemoryGrantsPending() {
    return memManager("Memory Grants Pending");
  }

  @Override
  public double getTotalServerMemoryKB() {
    return memManager("Total Server Memory (KB)");
  }

  @Override
  public double getTargetServerMemoryKB() {
    return memManager("Target Server Memory (KB)");
  }

  private double memManager(final String counter) {
    return perfmon.getRawValue(MEM_MANAGER, counter);
  }
}
