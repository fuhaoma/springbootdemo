package com.mfh.rabbit.dao;

import com.mfh.rabbit.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Integer> {
  Result findByUserId(Integer id);
}
