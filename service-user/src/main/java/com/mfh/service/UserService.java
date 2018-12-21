package com.mfh.service;

import com.mfh.dao.UserRepository;
import com.mfh.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserRepository repository;

    public User getUser(Integer id) {
        return repository.getOne(id);
    }
}
