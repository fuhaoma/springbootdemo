package com.mfh.rabbit.service.impl;

import com.mfh.rabbit.dao.TicketRepository;
import com.mfh.rabbit.entity.Ticket;
import com.mfh.rabbit.service.TicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TicketServiceImpl implements TicketService {
  @Resource
  private TicketRepository repository;

  @Override
  public Ticket findById(Integer id) {
    return repository.getOne(id);
  }

  @Override
  public int update(Integer id) {
    return repository.findByCount(id);
  }

  @Override
  public int count(Integer id) {
    return repository.count(id);
  }
}
