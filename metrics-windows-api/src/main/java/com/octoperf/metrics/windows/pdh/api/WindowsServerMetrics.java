package com.octoperf.metrics.windows.pdh.api;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource("Windows:type=Server")
public interface WindowsServerMetrics {

  @ManagedMetric(
    unit = "bytes/sec",
    displayName = "Bytes Total/sec",
    description = "Shows the rate at which the server is transmitting bytes through the network. This value provides an overall indication of how busy the server is.")
  double getBytesTotalPerSec();

  @ManagedMetric(
    unit = "bytes/sec",
    displayName = "Bytes Received/sec",
    description = "Shows the rate at which the server is receiving bytes from the network. This counter indicates how busy the server is.")
  double getBytesReceivedPerSec();

  @ManagedMetric(
    unit = "bytes/sec",
    displayName = "Bytes Transmitted/sec",
    description = "Shows the rate at which the server is sending bytes on the network. This counter indicates how busy the server is.")
  double getBytesTransmittedPerSec();

  @ManagedMetric(
    unit = "sessions",
    displayName = "Sessions Timed Out",
    description = "Shows the number of sessions that have been closed because idle time exceeded the AutoDisconnect " +
    "parameter for the server. This counter shows whether the AutoDisconnect setting is helping to conserve resources.")
  double getSessionsTimedOut();

  @ManagedMetric(
    unit = "sessions",
    displayName = "Sessions Errored Out",
    description = "Shows the number of sessions that have been closed due to unexpected error conditions. " +
    "This counter indicates how frequently network problems are causing dropped sessions on the server. The " +
    "Sessions Errored Out counter reports auto-disconnects along with errored-out sessions. For a more " +
    "accurate value for errored-out sessions, obtain the value for Sessions Timed Out and reduce the Sessions Errored Out value by that amount.")
  double getSessionsErroredOut();

  @ManagedMetric(
    unit = "sessions",
    displayName = "Sessions Logged Off",
    description = "Shows the number of sessions that have terminated normally. This counter is useful in " +
    "interpreting the statistics from Sessions Timed Out and Sessions Errored Out.")
  double getSessionsLoggedOff();

  @ManagedMetric(
    unit = "sessions",
    displayName = "Sessions Forced Off",
    description = "Shows the number of sessions that have been forced to log off. This counter can indicate " +
    "how many sessions were forced to log off due to logon time constraints.")
  double getSessionsForcedOff();

  @ManagedMetric(
    unit = "errors",
    displayName = "Errors Logon",
    description = "Shows the number of failed logon attempts to the server. This counter can indicate whether " +
    "password guessing programs are being used to crack the security on the server.")
  double getErrorsLogon();

  @ManagedMetric(
    unit = "errors",
    displayName = "Errors Access Permissions",
    description = "Shows the number of times attempts to open files on behalf of clients have failed with " +
    "the message STATUS_ACCESS_DENIED. This counter can indicate is someone is attempting to access random " +
    "files to improperly access a file that was not properly protected.")
  double getErrorsAccessPermissions();

  @ManagedMetric(
    unit = "errors",
    displayName = "Errors Granted Access",
    description = "Shows the number of times that attempts to access files successfully opened were denied. " +
    "This counter can indicate attempts to access files without proper access authorization.")
  double getErrorsGrantedAccess();

  @ManagedMetric(
    unit = "errors",
    displayName = "Errors System",
    description = "Shows the number of times that an internal server error was detected. Errors can reflect " +
    "problems with logon, security, memory allocation, disk operations, transport driver interface operations, " +
    "communication (such as receipt of unimplemented or unrecognized SMBs), or I/O Request Packet stack size " +
    "for the server. Many of these errors are also written to the System log and Security log in Event Viewer. " +
    "The server can recover from most the errors displayed by this counter, but they are unexpected and should be reported to Microsoft Product Support Services.")
  double getErrorsSystem();

  @ManagedMetric(
    unit = "rejected",
    displayName = "Blocking Requests Rejected",
    description = "Shows the number of times that the server has rejected blocking server message block requests " +
    "(SMBs) due to insufficient count of free work items. This counter indicates whether the MaxWorkItem or MinFreeWorkItems server registry parameters might need tuning.")
  double getBlockingRequestsRejected();

  @ManagedMetric(
    unit = "shortages",
    displayName = "Work Item Shortages",
    description = "Shows the number of times STATUS_DATA_NOT_ACCEPTED was returned at receive indication time. " +
    "This occurs when no work item is available or can be allocated to service the incoming request. This counter " +
    "indicates whether the InitWorkItems or MaxWorkItems registry entries might need to be adjusted.")
  double getWorkItemShortages();

  @ManagedMetric(
    unit = "files",
    displayName = "Files Opened Total",
    description = "Shows the number of successful attempts to open a file performed by the server of behalf of " +
    "clients. This counter is useful in determining the amounts of file I/O and overhead for path-based operations, and for determining the effectiveness of open locks.")
  double getFilesOpenedTotal();

  @ManagedMetric(
    unit = "files",
    displayName = "Files Open",
    description = "Shows the number of files currently opened on the server. This counter indicates current server activity.")
  double getFilesOpen();

  @ManagedMetric(
    unit = "sessions",
    displayName = "Server Sessions",
    description = "Shows the number of sessions currently active in the server. This counter indicates current server activity.")
  double getServerSessions();

  @ManagedMetric(
    unit = "searches",
    displayName = "File Directory Searches",
    description = "Shows the number of searches for files currently active in the server. This counter indicates current server activity.")
  double getFileDirectorySearches();

  @ManagedMetric(
    unit = "bytes",
    displayName = "Pool Nonpaged Bytes",
    description = "Shows the size, in bytes, of nonpageable computer memory that the server is currently using. " +
    "This value is useful for determining the values of the MaxNonpagedMemoryUsage entry in the Windows Registry.")
  double getPoolNonpagedBytes();

  @ManagedMetric(
    unit = "failures",
    displayName = "Pool Nonpaged Failures",
    description = "Shows how many times allocations from the nonpaged pool have failed. This counter indicates that the computer's physical memory is too small.")
  double getPoolNonpagedFailures();

  @ManagedMetric(
    unit = "nonpaged",
    displayName = "Pool Nonpaged Peak",
    description = "Shows the maximum size, in bytes, of the nonpaged pool the server has had in use at any one point. " +
    "This counter indicates how much physical memory the computer should have.")
  double getPoolNonpagedPeak();

  @ManagedMetric(
    unit = "bytes",
    displayName = "Pool Paged Bytes",
    description = "Shows the size, in bytes, of pageable computer memory that the server is currently using. " +
    "This counter can help in determining good values for the MaxPagedMemoryUsage registry entry.")
  double getPoolPagedBytes();

  @ManagedMetric(
    unit = "failures",
    displayName = "Pool Paged Failures",
    description = "Shows how many times allocations from the paged pool have failed. This counter indicates that the " +
    "computer's physical memory or page file are too small.")
  double getPoolPagedFailures();

  @ManagedMetric(
    unit = "paged",
    displayName = "Pool Paged Peak",
    description = "Shows the maximum size, in bytes, of the paged pool that the server has allocated. This counter " +
    "indicates the proper sizes of the page file(s) and physical memory.")
  double getPoolPagedPeak();

  @ManagedMetric(
    unit = "blocks/sec",
    displayName = "Context Blocks Queued/sec",
    description = "Shows the rate at which work context blocks had to be placed on the server's FSP queue to await server action.")
  double getContextBlocksQueuedPerSec();

  @ManagedMetric(
    unit = "logon/sec",
    displayName = "Logon/sec",
    description = "Shows the rate of all interactive logon attempts, network logon attempts, service logon attempts, successful logon attempts, and failed logon attempts.")
  double getLogonPerSec();

  @ManagedMetric(
    unit = "logons",
    displayName = "Logon Total",
    description = "Shows all interactive logon attempts, network logon attempts, service logon attempts, successful " +
    "logon attempts, and failed logon attempts since the computer was last rebooted.")
  double getLogonTotal();

  @ManagedMetric(
    unit = "handles",
    displayName = "Total Durable Handles",
    description = "The number of durable handles, it indicates how many durable handles keep alive ever when SMB2 sessions are disconnected.")
  double getTotalDurableHandles();

  @ManagedMetric(
    unit = "handles",
    displayName = "Reconnected Durable Handles",
    description = "The number of reconnected durable handles, the ratio of \"reconnected durable handles\"/\"total " +
    "durable handles\" indicates how much performance gain from reconnect durable handles.")
  double getReconnectedDurableHandles();

  @ManagedMetric(
    unit = "requests",
    displayName = "SMB BranchCache Hash Header Requests",
    description = "The number of SMB BranchCache hash requests that were for the header only received by the server. " +
    "This indicates how many requests are being done to validate hashes that are already cached by the client.")
  double getSMBBranchCacheHashHeaderRequests();

  @ManagedMetric(
    unit = "requests",
    displayName = "SMB BranchCache Hash Generation Requests",
    description = "The number of SMB BranchCache hash generation requests that were sent by SRV2 to the SMB Hash " +
    "Generation service because a client requested hashes for the file and there was either no hash content for the file or the existing hashes were out of date,.")
  double getSMBBranchCacheHashGenerationRequests();

  @ManagedMetric(
    unit = "requests",
    displayName = "SMB BranchCache Hash Requests Received",
    description = "The number of SMB BranchCache hash requests that were received by the server.")
  double getSMBBranchCacheHashRequestsReceived();

  @ManagedMetric(
    unit = "responses",
    displayName = "SMB BranchCache Hash Responses Sent",
    description = "The number of SMB BranchCache hash responses that have been sent from the server.")
  double getSMBBranchCacheHashResponsesSent();

  @ManagedMetric(
    unit = "bytes",
    displayName = "SMB BranchCache Hash Bytes Sent",
    description = "The amount of SMB BranchCache hash data sent from the server. This includes bytes transferred " +
    "for both hash header requests and full hash data requests.")
  double getSMBBranchCacheHashBytesSent();

  @ManagedMetric(
    unit = "handles",
    displayName = "Total Resilient Handles",
    description = "The number of resilient handles, it indicates how many resilient handles keep alive ever when " +
    "SMB2 sessions are disconnected.")
  double getTotalResilientHandles();

  @ManagedMetric(
    unit = "handles",
    displayName = "Reconnected Resilient Handles",
    description = "The number of reconnected resilient handles, the ratio of \"reconnected resilient handles\"/\"total resilient handles\" " +
    "indicates how much performance gain from reconnect resilient handles.")
  double getReconnectedResilientHandles();

  @ManagedMetric(
    unit = "requests",
    displayName = "SMB BranchCache Hash V2 Header Requests",
    description = "The number of SMB BranchCache hash requests that were for the header only received by the server. " +
    "This indicates how many requests are being done to validate hashes that are already cached by the client.")
  double getSMBBranchCacheHashV2HeaderRequests();

  @ManagedMetric(
    unit = "requests",
    displayName = "SMB BranchCache Hash V2 Generation Requests",
    description = "The number of SMB BranchCache hash generation requests that were sent by SRV2 to the SMB Hash " +
    "Generation service because a client requested hashes for the file and there was either no hash content for the file or the existing hashes were out of date.")
  double getSMBBranchCacheHashV2GenerationRequests();

  @ManagedMetric(
    unit = "requests",
    displayName = "SMB BranchCache Hash V2 Requests Received",
    description = "The number of SMB BranchCache hash requests that were received by the server.")
  double getSMBBranchCacheHashV2RequestsReceived();

  @ManagedMetric(
    displayName = "SMB BranchCache Hash V2 Responses Sent",
    unit = "responses",
    description = "The number of SMB BranchCache hash responses that have been sent from the server.")
  double getSMBBranchCacheHashV2ResponsesSent();

  @ManagedMetric(
    displayName = "SMB BranchCache Hash V2 Bytes Sent",
    unit = "bytes",
    description = "The amount of SMB BranchCache hash data sent from the server. This includes bytes transferred for both hash header requests and full hash data requests.")
  double getSMBBranchCacheHashV2BytesSent();

  @ManagedMetric(
    displayName = "SMB BranchCache Hash V2 Requests Served From Dedup",
    unit = "requests",
    description = "SMB BranchCache Hash V2 Requests Served From Dedup.")
  double getSMBBranchCacheHashV2RequestsServedFromDedup();
}
