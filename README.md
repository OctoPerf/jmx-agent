# jmx-agent

The JMX Agent uses [Hyperic Sigar](https://github.com/hyperic/sigar) and PDH to exposes Operating System key performance metrics using JMX. Sigar is uses for Linux and PDH for Windows.

# Build from sources

Run the following command at the root of the project:

> mvn clean package

The executable JAR file is built in metrics-agent/target folder.
