package com.mfh.rabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.mfh.rabbit.dao"})
@EntityScan(basePackages = {"com.mfh.rabbit.entity"})
@EnableRabbit
public class RabbitApplication {
  public static void main(String[] args) {
    SpringApplication.run(RabbitApplication.class, args);
  }
}
