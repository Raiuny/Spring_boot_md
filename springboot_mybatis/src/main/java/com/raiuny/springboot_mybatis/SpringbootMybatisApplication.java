package com.raiuny.springboot_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.raiuny.springboot_mybatis.dao")//修饰范围，作用在类上，用来扫描dao接口所在包，同时将所有dao接口在工厂中创建代理对象
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
