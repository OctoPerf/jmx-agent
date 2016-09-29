package com.octoperf.metrics.windows.pdh.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource("Windows:type=Server")
public interface WindowsServerMetrics {

  @ManagedMetric(
    unit = "bytes/sec",
    displayName = "Bytes Total/sec")
  double getBytesTotalPerSec();

  @ManagedMetric(
    unit = "bytes/sec",
    displayName = "Bytes Received/sec")
  double getBytesReceivedPerSec();

  @ManagedMetric(
    unit = "bytes/sec",
    displayName = "Bytes Transmitted/sec")
  double getBytesTransmittedPerSec();

  @ManagedMetric(
    unit = "sessions",
    displayName = "Sessions Timed Out")
  double getSessionsTimedOut();

  @ManagedMetric(
    unit = "sessions",
    displayName = "Sessions Errored Out")
  double getSessionsErroredOut();

  @ManagedMetric(
    unit = "sessions",
    displayName = "Sessions Logged Off")
  double getSessionsLoggedOff();

  @ManagedMetric(
    unit = "sessions",
    displayName = "Sessions Forced Off")
  double getSessionsForcedOff();

  @ManagedMetric(
    unit = "errors",
    displayName = "Errors Logon")
  double getErrorsLogon();

  @ManagedMetric(
    unit = "errors",
    displayName = "Errors Access Permissions")
  double getErrorsAccessPermissions();

  @ManagedMetric(
    unit = "errors",
    displayName = "Errors Granted Access")
  double getErrorsGrantedAccess();

  @ManagedMetric(
    unit = "errors",
    displayName = "Errors System")
  double getErrorsSystem();

  @ManagedMetric(
    unit = "rejected",
    displayName = "Blocking Requests Rejected")
  double getBlockingRequestsRejected();

  @ManagedMetric(
    unit = "shortages",
    displayName = "Work Item Shortages")
  double getWorkItemShortages();

  @ManagedMetric(
    unit = "files",
    displayName = "Files Opened Total")
  double getFilesOpenedTotal();

  @ManagedMetric(
    unit = "files",
    displayName = "Files Open")
  double getFilesOpen();

  @ManagedMetric(
    unit = "sessions",
    displayName = "Server Sessions")
  double getServerSessions();

  @ManagedMetric(
    unit = "searches",
    displayName = "File Directory Searches")
  double getFileDirectorySearches();

  @ManagedMetric(
    unit = "bytes",
    displayName = "Pool Nonpaged Bytes")
  double getPoolNonpagedBytes();

  @ManagedMetric(
    unit = "failures",
    displayName = "Pool Nonpaged Failures")
  double getPoolNonpagedFailures();

  @ManagedMetric(
    unit = "nonpaged",
    displayName = "Pool Nonpaged Peak")
  double getPoolNonpagedPeak();

  @ManagedMetric(
    unit = "bytes",
    displayName = "Pool Paged Bytes")
  double getPoolPagedBytes();

  @ManagedMetric(
    unit = "failures",
    displayName = "Pool Paged Failures")
  double getPoolPagedFailures();

  @ManagedMetric(
    unit = "paged",
    displayName = "Pool Paged Peak")
  double getPoolPagedPeak();

  @ManagedMetric(
    unit = "blocks/sec",
    displayName = "Context Blocks Queued/sec")
  double getContextBlocksQueuedPerSec();

  @ManagedMetric(
    unit = "logon/sec",
    displayName = "Logon/sec")
  double getLogonPerSec();

  @ManagedMetric(
    unit = "logons",
    displayName = "Logon Total")
  double getLogonTotal();

  @ManagedMetric(
    unit = "handles",
    displayName = "Total Durable Handles")
  double getTotalDurableHandles();

  @ManagedMetric(
    unit = "handles",
    displayName = "Reconnected Durable Handles")
  double getReconnectedDurableHandles();

  @ManagedMetric(
    unit = "requests",
    displayName = "SMB BranchCache Hash Header Requests")
  double getSMBBranchCacheHashHeaderRequests();

  @ManagedMetric(
    unit = "requests",
    displayName = "SMB BranchCache Hash Generation Requests")
  double getSMBBranchCacheHashGenerationRequests();

  @ManagedMetric(
    unit = "requests",
    description = "SMB BranchCache Hash Requests Received")
  double getSMBBranchCacheHashRequestsReceived();

  @ManagedMetric(
    unit = "responses",
    displayName = "SMB BranchCache Hash Responses Sent")
  double getSMBBranchCacheHashResponsesSent();

  @ManagedMetric(
    unit = "bytes",
    displayName = "SMB BranchCache Hash Bytes Sent")
  double getSMBBranchCacheHashBytesSent();

  @ManagedMetric(
    unit = "handles",
    displayName = "Total Resilient Handles")
  double getTotalResilientHandles();

  @ManagedMetric(
    unit = "handles",
    displayName = "Reconnected Resilient Handles")
  double getReconnectedResilientHandles();

  @ManagedMetric(
    unit = "requests",
    displayName = "SMB BranchCache Hash V2 Header Requests")
  double getSMBBranchCacheHashV2HeaderRequests();

  @ManagedMetric(
    unit = "requests",
    displayName = "SMB BranchCache Hash V2 Generation Requests")
  double getSMBBranchCacheHashV2GenerationRequests();

  @ManagedMetric(
    unit = "requests",
    displayName = "SMB BranchCache Hash V2 Requests Received")
  double getSMBBranchCacheHashV2RequestsReceived();

  @ManagedMetric(
    displayName = "SMB BranchCache Hash V2 Responses Sent",
    unit = "responses")
  double getSMBBranchCacheHashV2ResponsesSent();

  @ManagedMetric(
    displayName = "SMB BranchCache Hash V2 Bytes Sent",
    unit = "bytes",
    description = "SMB BranchCache Hash V2 Bytes Sent")
  double getSMBBranchCacheHashV2BytesSent();

  @ManagedMetric(
    displayName = "SMB BranchCache Hash V2 Requests Served From Dedup",
    unit = "requests",
    description = "SMB BranchCache Hash V2 Requests Served From Dedup")
  double getSMBBranchCacheHashV2RequestsServedFromDedup();
}
