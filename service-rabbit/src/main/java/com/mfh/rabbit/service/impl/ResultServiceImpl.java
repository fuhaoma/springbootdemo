package com.mfh.rabbit.service.impl;

import com.mfh.rabbit.dao.ResultRepository;
import com.mfh.rabbit.entity.Result;
import com.mfh.rabbit.service.ResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResultServiceImpl implements ResultService {
  @Resource
  private ResultRepository resultRepository;

  @Override
  public Result save(Result result) {
    return resultRepository.save(result);
  }

  @Override
  public Result findByUserId(Integer id) {
    return resultRepository.findByUserId(id);
  }
}
