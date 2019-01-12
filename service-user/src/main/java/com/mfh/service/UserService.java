package com.mfh.service;

import com.mfh.dao.UserRepository;
import com.mfh.entity.User;
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

    public List<String> getAge() {
        return repository.getAge();
    }
    public List<String> getAgeAndName() {
        return repository.getAgeAndName();
    }
}
