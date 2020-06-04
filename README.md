# JMX Metrics Agent

**WARNING: Runs with Java 8 Only**

The JMX Metrics Agent uses [Hyperic Sigar](https://github.com/hyperic/sigar) and PDH to exposes Operating System key performance metrics using JMX. Sigar is uses for Linux and PDH for Windows. The following metrics are available: (non-exhaustive)

- CPU usage,
- Network Interfaces usage,
- Hard disk drives usage,
- Per Process metrics (CPU, Mem...),
- TCP metrics,
- and Memory (RAM, Swap) usage.

Windows users can also monitor the following servers metrics:

- Microsoft SQL Server,
* Microsoft IIS.

## Requirements

The JMX Agent is a java application which requires a Java Runtime Environment.

## Execute

To run the JMX Metrics Agent:

- Download latest version from [Releases](https://github.com/OctoPerf/jmx-agent/releases),
- Place it in a folder writeable by your user (Example: Documents on Windows),
- Run via command line: *java -Djmx.rmi.host=HOSTNAME -jar metrics-agent-X.x.x.jar*, Replace X.x.x by the version, and `HOSTNAME` by the hostname of your machine.

The metrics agent takes a few seconds to start. It create a "native" folder in the location where its being run. The "native" folder contains DLLs and SOs to query operating system metrics.

## Host, Port and Firewalls

**Agent host (or IP) must be specified**. Specify the IP or the hostname of the machine where the agent is running:

> java -Djmx.rmi.host=<host or ip> ... -jar metrics-agent-X.x.x.jar

**The agent exposes the JMX beans on port 1099**. This port can be changed by specifying the JMX RMI port on startup:

> java ... -Djmx.rmi.port=9004 -jar metrics-agent-X.x.x.jar

In the example above, the agent starts the JMX beans server on port 9004.

## Metrics Exposed

The agent exposes the following JMX Domains:

- **Sigar** on Linux systems,
* **Windows** and **SQLServer** on Windows.

## Build from sources

Run the following command at the root of the project:

> mvn clean package

The executable JAR file is built in metrics-agent/target folder.

## Contributing

Pull requests are welcome if you would like to add additional metrics.
