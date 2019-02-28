package com.mfh.rabbit.service;

import com.mfh.rabbit.entity.Ticket;
import org.springframework.stereotype.Service;

@Service
public interface TicketService {
  Ticket findById(Integer id);
  int update(Integer id);
  int count(Integer id);
}
