package com.octoperf.metrics.windows.pdh;

import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import com.octoperf.metrics.windows.pdh.api.WindowsTcpMetrics;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.win32.Pdh;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PACKAGE;

@Component
@ConditionalOnBean(Pdh.class)
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PdhTcpMetrics implements WindowsTcpMetrics {
  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getSegmentsPerSec() {
    return perSecond("Segments/sec");
  }

  @Override
  public double getConnectionsEstablished() {
    return tcp("Connections Established");
  }

  @Override
  public double getConnectionsActive() {
    return tcp("Connections Active");
  }

  @Override
  public double getConnectionsPassive() {
    return tcp("Connections Passive");
  }

  @Override
  public double getConnectionFailures() {
    return tcp("Connection Failures");
  }

  @Override
  public double getConnectionsReset() {
    return tcp("Connections Reset");
  }

  @Override
  public double getSegmentsReceivedPerSec() {
    return perSecond("Segments Received/sec");
  }

  @Override
  public double getSegmentsSentPerSec() {
    return perSecond("Segments Sent/sec");
  }

  @Override
  public double getSegmentsRetransmittedPerSec() {
    return perSecond("Segments Retransmitted/sec");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> tcp(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double tcp(final String counter) {
    return perfmon.getRawValue("TCPv4", counter);
  }
}
