package com.mfh.rabbit.service;

import com.google.gson.Gson;
import com.mfh.rabbit.rabbit.MQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class MQSenderService {
  @Resource
  private AmqpTemplate amqpTemplate;

  public void send(Object obj) {
    String msg = new Gson().toJson(obj);
    log.info("send msg" + msg);
    amqpTemplate.convertAndSend(MQConfig.QUEUE,msg);
  }
}
