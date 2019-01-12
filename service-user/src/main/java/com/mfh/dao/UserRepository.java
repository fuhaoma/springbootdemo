package com.mfh.dao;

import com.mfh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where id=?1", nativeQuery = true)
    Optional<User> getUser(Integer id);

    Optional<User> findById(Integer id);

    @Query(value = "select age from user", nativeQuery = true)
    List<String> getAge();

    @Query(value = "select age,name from user", nativeQuery = true)
    List<String> getAgeAndName();
}
