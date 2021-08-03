package com.raiuny.springboot_mybatis;

import com.raiuny.springboot_mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        userService.findAll().forEach(user -> System.out.println(user.getName()));
    }

}
