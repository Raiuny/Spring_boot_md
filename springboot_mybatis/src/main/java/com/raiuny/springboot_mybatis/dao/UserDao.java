package com.raiuny.springboot_mybatis.dao;
import com.raiuny.springboot_mybatis.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void save(User user);
}
