package com.octoperf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import java.lang.management.ManagementFactory;

@Configuration
class JMXConfig {

  public static final String JMX_URL = "service:jmx:rmi://%s:%s/jndi/rmi://%s:%s/jmxrmi";
  @Value("${jmx.rmi.host:localhost}")
  private String rmiHost;

  @Value("${jmx.rmi.port:1099}")
  private Integer rmiPort;

  @Bean
  public RmiRegistryFactoryBean rmiRegistry() {
    final RmiRegistryFactoryBean factory = new RmiRegistryFactoryBean();
    factory.setPort(rmiPort);
    factory.setAlwaysCreate(true);
    return factory;
  }

  @Bean
  @DependsOn("rmiRegistry")
  public ConnectorServerFactoryBean connector() throws MalformedObjectNameException {
    final ConnectorServerFactoryBean factory = new ConnectorServerFactoryBean();
    factory.setObjectName("connector:name=rmi");
    factory.setServiceUrl(String.format(JMX_URL, rmiHost, rmiPort, rmiHost, rmiPort));
    return factory;
  }

  @Bean
  MBeanServer mbeanServer() {
    return ManagementFactory.getPlatformMBeanServer();
  }
}
