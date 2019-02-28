package com.mfh.activiti.config;

import com.mfh.activiti.SpringUtils;
import org.flowable.common.engine.impl.cfg.IdGenerator;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowableConfig {
  @Bean
  public EngineConfigurationConfigurer<SpringProcessEngineConfiguration> customIdGeneratorConfigurer() {
    return engineConfiguration -> engineConfiguration.setIdGenerator((IdGenerator) SpringUtils::UUID);
  }
}
