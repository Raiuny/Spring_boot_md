package com.example.aopstu;

import com.example.aopstu.Aop.Cal;
import com.example.aopstu.Aop.CalImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class AopStuApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopStuApplication.class, args);
    }
}
