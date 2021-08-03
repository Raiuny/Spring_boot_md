package com.raiuny.springboot_mybatis.service;

import com.raiuny.springboot_mybatis.entity.User;

import java.util.List;

public interface UserService {
    //查询所有
    List<User> findAll();
    void save(User user);
}
