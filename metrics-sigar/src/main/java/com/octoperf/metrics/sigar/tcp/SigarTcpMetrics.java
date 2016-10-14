package com.octoperf.metrics.sigar.tcp;

import com.octoperf.metrics.api.TcpMetrics;
import com.octoperf.metrics.condition.IsNotWindows;
import com.octoperf.metrics.service.api.UnitConversionService;
import javaslang.control.Try;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.hyperic.sigar.Tcp;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Component
@Conditional(IsNotWindows.class)
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class SigarTcpMetrics implements TcpMetrics {
  @NonNull
  UnitConversionService units;
  @NonNull
  Try.CheckedSupplier<Tcp> tcp;

  @Override
  public long getActiveConnectionOpenings() {
    return units.map(tcp, Tcp::getActiveOpens, 0L);
  }

  @Override
  public long getFailedConnectionAttempts() {
    return units.map(tcp, Tcp::getAttemptFails, 0L);
  }

  @Override
  public long getPassiveConnectionOpenings() {
    return units.map(tcp, Tcp::getPassiveOpens, 0L);
  }

  @Override
  public long getConnectionsEstablished() {
    return units.map(tcp, Tcp::getCurrEstab, 0L);
  }

  @Override
  public long getConnectionResets() {
    return units.map(tcp, Tcp::getEstabResets, 0L);
  }

  @Override
  public long getSegmentRetransmitted() {
    return units.map(tcp, Tcp::getRetransSegs, 0L);
  }

  @Override
  public long getBadSegmentsReceived() {
    return units.map(tcp, Tcp::getInErrs, 0L);
  }

  @Override
  public long getSegmentsSentOut() {
    return units.map(tcp, Tcp::getOutSegs, 0L);
  }

  @Override
  public long getResetsSent() {
    return units.map(tcp, Tcp::getOutRsts, 0L);
  }
}
