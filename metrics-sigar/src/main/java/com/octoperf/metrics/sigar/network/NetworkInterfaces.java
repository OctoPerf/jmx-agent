package com.octoperf.metrics.sigar.network;

import com.google.common.collect.ImmutableSet;
import com.octoperf.metrics.api.NetworkInterfaceMetrics;
import com.octoperf.metrics.condition.IsNotWindows;
import com.octoperf.metrics.service.api.CachingService;
import com.octoperf.metrics.service.api.UnitConversionService;
import javaslang.control.Try;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.context.annotation.Conditional;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.stereotype.Service;

import javax.management.JMException;
import javax.management.ObjectName;

import static java.lang.String.format;

@Service
@Conditional(IsNotWindows.class)
final class NetworkInterfaces {
  private static final String OBJECT_NAME = "Sigar:type=NetworkInterface,name=%s";

  NetworkInterfaces(
    final UnitConversionService units,
    final CachingService caching,
    final Sigar sigar,
    final AnnotationMBeanExporter server) throws SigarException, JMException {
    super();

    for(final String iface : ImmutableSet.copyOf(sigar.getNetInterfaceList())) {
      final NetInterfaceConfig config = sigar.getNetInterfaceConfig(iface);
      final Try.CheckedSupplier<NetInterfaceStat> stats = caching
        .cache(() -> sigar.getNetInterfaceStat(iface));
      final String name = config.getName();
      final NetworkInterfaceMetrics info = SigarNetworkInterfaceMetrics
        .builder()
        .name(name)
        .stats(stats)
        .units(units)
        .build();
      server.registerManagedResource(info, new ObjectName(format(OBJECT_NAME, ObjectName.quote(name))));
    }
  }
}
