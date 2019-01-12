package com.mfh.core.base.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author :mfh
 * @Date :Created in 12:08 2019/1/11
 * @Description :数据库配置
 * @Version :V1.0
 */
@Configuration
public class DataSourceConfig {

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource mysqlDataSource() {
    return DruidDataSourceBuilder.create().build();
  }
}
