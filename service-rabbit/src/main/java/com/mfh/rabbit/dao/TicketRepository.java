package com.mfh.rabbit.dao;

import com.mfh.rabbit.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

  @Transactional
  @Modifying
  @Query(value = "update ticket t set t.total=t.total+(-1) where t.id=?1", nativeQuery = true)
  int findByCount(Integer id);

  @Query(value = "select t.total from ticket t where t.id=?1",nativeQuery = true)
  int count(Integer id);
}
