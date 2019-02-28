package com.mfh.rabbit.controller;

import com.mfh.rabbit.rabbit.Message;
import com.mfh.rabbit.service.MQSenderService;
import com.mfh.rabbit.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("mfh/ticket")
public class TicketController {
  @Resource
  private TicketService ticketService;
  @Resource
  private MQSenderService mqSenderService;

  @GetMapping("/{id}")
  public Object getId(@PathVariable Integer id) {
    return ticketService.findById(id);
  }

  @GetMapping("/reduce/{id}/{userId}")
  public String reduceCount(@PathVariable Integer id,
                            @PathVariable Integer userId) {
    Message message = new Message().setTicketId(id).setUserId(userId);
    mqSenderService.send(message);
    return "抢票成功";
  }
}
