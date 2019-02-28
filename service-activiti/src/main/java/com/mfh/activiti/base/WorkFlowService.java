package com.mfh.activiti.base;

import org.flowable.engine.RuntimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WorkFlowService {

  @Resource
  private RuntimeService runtimeService;

  public void startProcesses(String key) {
    runtimeService.startProcessInstanceByKey(key);
  }
}
