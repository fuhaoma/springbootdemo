package com.mfh.activiti.base;

import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;


@Service
public class ActivitiConfig {

  public void start(DelegateExecution execution) {
    execution.setVariable("sss","123");
    System.out.println("启动activiti");
  }

  public void end(DelegateExecution execution){
    String sss = execution.getVariable("sss").toString();
    System.out.println("结束activiti："+sss);
  }
}
