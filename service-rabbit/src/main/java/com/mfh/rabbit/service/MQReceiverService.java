package com.mfh.rabbit.service;

import com.google.gson.Gson;
import com.mfh.rabbit.entity.Result;
import com.mfh.rabbit.rabbit.MQConfig;
import com.mfh.rabbit.rabbit.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class MQReceiverService {

  @Resource
  private TicketService ticketService;
  @Resource
  private ResultService resultService;

  @RabbitListener(queues = MQConfig.QUEUE)
  public void receiver(String msg) {
    log.info("receiver msg" + msg);
    Message message = new Gson().fromJson(msg, Message.class);
    final Integer ticketId = message.getTicketId();
    final Integer userId = message.getUserId();
    int reduceCount = ticketService.count(ticketId);
    if (reduceCount <= 0) {
      return;
    }
    Result result = resultService.findByUserId(userId);
    if (result != null) {
      return;
    }
    ticketService.update(ticketId);
    Result save = resultService.save(new Result().setUserId(userId).setTicketId(ticketId));
    log.info("receiver result" + save.toString());
  }
}
