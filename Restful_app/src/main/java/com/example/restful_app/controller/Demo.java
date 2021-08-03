package com.example.restful_app.controller;

import com.example.restful_app.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class Demo {

    @RequestMapping("findUserById")
    public String findUserById(Integer id) {
        //存储到作用域
        return "showOne";
    }

    @RequestMapping("findAll")
    public String findAll() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User(21,"dadf", 2123.0,new Date()));
        //存储到作用域
        return "showAll";
    }

    @RequestMapping("saveUser")
    public String save(User user) {
        //业务代码
        return "redirect:/user/findAll";
    }

    @RequestMapping("updateUser")
    public String update(User user) {
        return "redirect:/user/findAll";
    }

    @RequestMapping("delete")
    public String delete(User user) {
        return "redirect:/user/findAll";
    }
}
