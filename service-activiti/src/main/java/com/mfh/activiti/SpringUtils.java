package com.mfh.activiti;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

public class SpringUtils {
  private static final TimeBasedGenerator timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());

  public static String UUID() {
    return timeBasedGenerator.generate().toString().replaceAll("-", "");
  }
}
