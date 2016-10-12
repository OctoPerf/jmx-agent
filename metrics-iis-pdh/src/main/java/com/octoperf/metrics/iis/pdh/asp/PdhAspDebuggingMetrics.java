package com.octoperf.metrics.iis.pdh.asp;

import com.octoperf.metrics.condition.IsWindows;
import com.octoperf.metrics.iis.api.asp.ASPDebuggingMetrics;
import com.octoperf.metrics.iis.pdh.IsIIS;
import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PACKAGE;

@Component
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Conditional({IsWindows.class, IsIIS.class})
public final class PdhAspDebuggingMetrics implements ASPDebuggingMetrics {
  private static final String ASP = "Active Server Pages";

  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getASPDebuggingRequests() {
    return asp("Debugging Requests");
  }

  @Override
  public double getErrorsDuringScriptRuntime() {
    return asp("Errors During Script Runtime");
  }

  @Override
  public double getErrorsFromASPPreprocessor() {
    return asp("Errors From ASP Preprocessor");
  }

  @Override
  public double getErrorsFromScriptCompilers() {
    return asp("Errors From Script Compilers");
  }

  @Override
  public double getErrorsPerSec() {
    return perSecond("Errors/sec");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> asp(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double asp(final String counter) {
    return perfmon.getRawValue(ASP, counter);
  }
}
