package com.mfh.rabbit.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@Accessors(chain = true)
public class Ticket implements Serializable {
  private static final long serialVersionUID = -3085042232928332724L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String content;
  private String userName;
  private Integer total;
}
