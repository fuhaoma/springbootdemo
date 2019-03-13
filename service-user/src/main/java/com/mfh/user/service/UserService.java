package com.mfh.user.service;

import com.mfh.user.dao.UserRepository;
import com.mfh.user.entity.User;
import com.mfh.user.entity.UserE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Resource
  private UserRepository repository;

  public User getUser(Integer id) {
    Optional<User> user = repository.getUser(id);
    Optional one = repository.findById(id);
    return user.get();
  }

  public UserE getUserE(Integer id) {
    Optional<UserE> user = repository.getUserE(id);
    Optional one = repository.findById(id);
    return user.get();
  }

  public List<String> getAge() {
    return repository.getAge();
  }

  public List<String> getAgeAndName() {
    return repository.getAgeAndName();
  }
}
