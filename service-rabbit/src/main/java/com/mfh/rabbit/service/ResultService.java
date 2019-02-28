package com.mfh.rabbit.service;

import com.mfh.rabbit.entity.Result;
import org.springframework.stereotype.Service;

@Service
public interface ResultService {
  Result save(Result result);

  Result findByUserId(Integer id);
}
