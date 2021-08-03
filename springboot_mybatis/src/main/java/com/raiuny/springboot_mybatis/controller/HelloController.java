package com.raiuny.springboot_mybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        return "Hello Hust";

    }
}
