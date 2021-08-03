package com.raiuny.springboot_mybatis.controller;

import com.raiuny.springboot_mybatis.entity.User;
import com.raiuny.springboot_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("findAll")
    public List<User> findAll(){
        System.out.println("UserController");
        return userService.findAll();
    }
    @RequestMapping("save")
    public void save(User user) {
        userService.save(user);
    }
}
