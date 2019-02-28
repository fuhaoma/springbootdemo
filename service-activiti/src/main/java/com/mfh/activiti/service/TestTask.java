package com.mfh.activiti.service;

import com.mfh.activiti.base.ActivitiConfig;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TestTask implements JavaDelegate {
  @Resource
  private ActivitiConfig activitiConfig;

  @Override
  public void execute(DelegateExecution execution) {
    String sss = (String) execution.getVariable("sss");
    System.out.println("走到了测试任务节点：" + sss);
    execution.setVariable("sss", "走了测试任务节点");
//    activitiConfig.end(execution);
  }
}
