# JMX Metrics Agent

The JMX Metrics Agent uses [Hyperic Sigar](https://github.com/hyperic/sigar) and PDH to exposes Operating System key performance metrics using JMX. Sigar is uses for Linux and PDH for Windows.

## Requirements

The JMX Agent is a java application which requires a Java Runtime Environment.

## Execute

To run the JMX Metrics Agent:

- Download latest version from [Releases](https://github.com/OctoPerf/jmx-agent/releases),
- Place it in a folder writeable by your user (Example: Documents on Windows),
- Run via command line: *java - jar metrics-agent-X.x.x.jar*, Replace X.x.x by the version.

## Build from sources

Run the following command at the root of the project:

> mvn clean package

The executable JAR file is built in metrics-agent/target folder.
