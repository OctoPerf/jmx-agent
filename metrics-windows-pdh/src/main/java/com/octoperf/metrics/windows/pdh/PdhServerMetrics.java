package com.octoperf.metrics.windows.pdh;

import com.octoperf.metrics.service.api.Gauge;
import com.octoperf.metrics.service.api.GaugeService;
import com.octoperf.metrics.windows.pdh.api.PerfmonQueryService;
import com.octoperf.metrics.windows.pdh.api.WindowsServerMetrics;
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
public final class PdhServerMetrics implements WindowsServerMetrics {
  @NonNull
  PerfmonQueryService perfmon;
  @NonNull
  GaugeService gauges;

  @Override
  public double getBytesTotalPerSec() {
    return perSecond("Bytes Total/sec");
  }

  @Override
  public double getBytesReceivedPerSec() {
    return perSecond("Bytes Received/sec");
  }

  @Override
  public double getBytesTransmittedPerSec() {
    return perSecond("Bytes Transmitted/sec");
  }

  @Override
  public double getSessionsTimedOut() {
    return server("Sessions Timed Out");
  }

  @Override
  public double getSessionsErroredOut() {
    return server("Sessions Errored Out");
  }

  @Override
  public double getSessionsLoggedOff() {
    return server("Sessions Logged Off");
  }

  @Override
  public double getSessionsForcedOff() {
    return server("Sessions Forced Off");
  }

  @Override
  public double getErrorsLogon() {
    return server("Errors Logon");
  }

  @Override
  public double getErrorsAccessPermissions() {
    return server("Errors Access Permissions");
  }

  @Override
  public double getErrorsGrantedAccess() {
    return server("Errors Granted Access");
  }

  @Override
  public double getErrorsSystem() {
    return server("Errors System");
  }

  @Override
  public double getBlockingRequestsRejected() {
    return server("Blocking Requests Rejected");
  }

  @Override
  public double getWorkItemShortages() {
    return server("Work Item Shortages");
  }

  @Override
  public double getFilesOpenedTotal() {
    return server("Files Opened Total");
  }

  @Override
  public double getFilesOpen() {
    return server("Files Open");
  }

  @Override
  public double getServerSessions() {
    return server("Server Sessions");
  }

  @Override
  public double getFileDirectorySearches() {
    return server("File Directory Searches");
  }

  @Override
  public double getPoolNonpagedBytes() {
    return server("Pool Nonpaged Bytes");
  }

  @Override
  public double getPoolNonpagedFailures() {
    return server("Pool Nonpaged Failures");
  }

  @Override
  public double getPoolNonpagedPeak() {
    return server("Pool Nonpaged Peak");
  }

  @Override
  public double getPoolPagedBytes() {
    return server("Pool Paged Bytes");
  }

  @Override
  public double getPoolPagedFailures() {
    return server("Pool Paged Failures");
  }

  @Override
  public double getPoolPagedPeak() {
    return server("Pool Paged Peak");
  }

  @Override
  public double getContextBlocksQueuedPerSec() {
    return perSecond("Context Blocks Queue/sec");
  }

  @Override
  public double getLogonPerSec() {
    return perSecond("Logon Per Sec");
  }

  @Override
  public double getLogonTotal() {
    return server("Logon Total");
  }

  @Override
  public double getTotalDurableHandles() {
    return server("Total Durable Handles");
  }

  @Override
  public double getReconnectedDurableHandles() {
    return server("Reconnected Durable Handles");
  }

  @Override
  public double getSMBBranchCacheHashHeaderRequests() {
    return server("SMB BranchCache Hash Header Requests");
  }

  @Override
  public double getSMBBranchCacheHashGenerationRequests() {
    return server("SMB BranchCache Hash Generation Requests");
  }

  @Override
  public double getSMBBranchCacheHashRequestsReceived() {
    return server("SMB BranchCache Hash Requests Received");
  }

  @Override
  public double getSMBBranchCacheHashResponsesSent() {
    return server("SMB BranchCache Hash Responses Sent");
  }

  @Override
  public double getSMBBranchCacheHashBytesSent() {
    return server("SMB BranchCache Hash Bytes Sent");
  }

  @Override
  public double getTotalResilientHandles() {
    return server("Total Resilient Handles");
  }

  @Override
  public double getReconnectedResilientHandles() {
    return server("Reconnected Resilient Handles");
  }

  @Override
  public double getSMBBranchCacheHashV2HeaderRequests() {
    return server("SMB BranchCache Hash V2 Header Requests");
  }

  @Override
  public double getSMBBranchCacheHashV2GenerationRequests() {
    return server("SMB BranchCache Hash V2 Generation Requests");
  }

  @Override
  public double getSMBBranchCacheHashV2RequestsReceived() {
    return server("SMB BranchCache Hash V2 Requests Received");
  }

  @Override
  public double getSMBBranchCacheHashV2ResponsesSent() {
    return server("SMB BranchCache Hash V2 Responses Sent");
  }

  @Override
  public double getSMBBranchCacheHashV2BytesSent() {
    return server("SMB BranchCache Hash V2 Bytes Sent");
  }

  @Override
  public double getSMBBranchCacheHashV2RequestsServedFromDedup() {
    return server("SMB BranchCache Hash V2 Requests Served From Dedup");
  }

  private double perSecond(final String counter) {
    final Gauge gauge = () -> server(counter);
    return gauges.cached(counter, gauges.perSecond(gauge)).getValue();
  }

  private double server(final String counter) {
    return perfmon.getRawValue("Server", counter);
  }
}
