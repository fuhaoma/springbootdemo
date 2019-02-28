package com.mfh.rabbit.rabbit;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Message implements Serializable {
  private Integer ticketId;
  private Integer userId;
}
