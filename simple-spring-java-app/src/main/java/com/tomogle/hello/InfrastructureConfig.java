package com.tomogle.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
public class InfrastructureConfig {

  @Bean
  DataSource dataSource() {
    return new DriverManagerDataSource();
  }
}
