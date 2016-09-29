package com.octoperf.metrics.sqlserver.pdh;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.mssql.api.SqlServerTransactionsMetrics;
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
public final class PdhSqlServerTransactionsMetrics implements SqlServerTransactionsMetrics {
  private static final String NAME = SQL_SERVER + ":Transactions";

  @NonNull
  PerfmonQueryService perfmon;

  @Override
  public double getLongestTransactionRunningTimeSec() {
    return transactions("Longest Transaction Running Time");
  }

  private double transactions(final String counter) {
    return perfmon.getRawValue(NAME, counter);
  }


}
