package com.yazici.huaweitask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

  @Value("${application.datasource.url}")
  private String url;

  @Value("${application.datasource.username}")
  private String username;

  @Value("${application.datasource.password}")
  private String password;

  @Bean
  public DataSource dataSource() {
    var dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.url(url);
    dataSourceBuilder.username(username);
    dataSourceBuilder.password(password);
    return dataSourceBuilder.build();
  }
}
