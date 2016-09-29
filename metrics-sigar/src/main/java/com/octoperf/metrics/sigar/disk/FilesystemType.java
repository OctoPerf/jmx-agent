package com.octoperf.metrics.sigar.disk;

public enum FilesystemType {
  // Ordered so that ordinals match the constants
  // in org.hyperic.sigar.FileSystem
  Unknown,
  None,
  LocalDisk,
  Network,
  Ramdisk,
  Cdrom,
  Swap
}