package com.octoperf.metrics.sigar.process;

import com.octoperf.metrics.service.api.CachingService;
import com.octoperf.metrics.service.api.UnitConversionService;
import com.octoperf.metrics.condition.IsNotWindows;
import org.hyperic.sigar.ProcState;
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
final class Processes {
  private static final String OBJECT_NAME = "Sigar:type=Process,name=\"%s (%s)\"";

  Processes(
    final UnitConversionService units,
    final CachingService caching,
    final Sigar sigar,
    final AnnotationMBeanExporter server) throws SigarException, JMException {
    super();

    for(final long pid : sigar.getProcList()) {
      try {
        final ProcState state = sigar.getProcState(pid);
        final String name = state.getName();

        final SigarProcessMetrics process = SigarProcessMetrics
          .builder()
          .units(units)
          .name(name)
          .pid(pid)
          .cpu(caching.cache(() -> sigar.getProcCpu(pid)))
          .memory(caching.cache(() -> sigar.getProcMem(pid)))
          .build();

        server.registerManagedResource(process, new ObjectName(format(OBJECT_NAME, name, pid)));
      } catch(final SigarException e) {
        // Process disappeared between listing and proc state
      }
    }
  }
}
