package com.mfh.activiti.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class TestTimer implements JavaDelegate {
  private int a =100;

  @Override
  public void execute(DelegateExecution execution) {
    execution.setVariable("isEnd", false);
//    a--;
//    if (a<=0) {
//      System.out.println("true");
//      execution.setVariable("isEnd", false);
//    }else {
//      System.out.println("false");
//    }
    System.out.println(a);
    System.out.println("进入循环");
  }
}
