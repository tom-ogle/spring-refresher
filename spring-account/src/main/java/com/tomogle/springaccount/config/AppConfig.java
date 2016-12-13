package com.tomogle.springaccount.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.tomogle.springaccount")
@PropertySource("classpath:dev.properties")
@EnableTransactionManagement
public class AppConfig {

  @Autowired
  private Environment environment;


  @Bean(name = "dataSource")
  @Profile("dev")
  public DataSource dataSourceForDev() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(environment.getProperty("db.driver"));
    dataSource.setUrl(environment.getProperty("db.url"));
    dataSource.setUsername(environment.getProperty("db.user"));
    dataSource.setPassword(environment.getProperty("db.pass"));
    return dataSource;
  }

  @Bean(name = "transactionManager")
  @Profile("dev")
  public PlatformTransactionManager transactionManagerForDev() {
    return new DataSourceTransactionManager(dataSourceForDev());
  }

  @Bean(name = "dataSource")
  @Profile("test")
  public DataSource dataSourceForTest() {
    return new EmbeddedDatabaseBuilder()
        .generateUniqueName(true)
        .setType(EmbeddedDatabaseType.H2)
        .setScriptEncoding("UTF-8")
        .ignoreFailedDrops(true)
        .addScript("schema.sql")
        .addScripts("testdata.sql")
        .build();
  }

  @Bean(name = "transactionManager")
  @Profile("test")
  public PlatformTransactionManager transactionManagerForTest() {
    return new DataSourceTransactionManager(dataSourceForTest());
  }
}
