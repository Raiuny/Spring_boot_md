package com.example.aopstu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

//修饰范围只能用在类上，作用：代表这个类为配置类，相当于Spring中的spring.xml
@Configuration
//需要里面配合@Bean实现向工厂中注入对象
public class MyConfiguration {
    @Bean //修饰范围：用在方法上或者注解上，作用：将方法的返回值交给工厂管理
    public Calendar cala() { //方法名代表当前创建对象在工厂中的名称
        return Calendar.getInstance();
    }
}
