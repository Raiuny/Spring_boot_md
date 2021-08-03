package com.example.fruit_show;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.fruit_show.mapper")
public class FruitShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(FruitShowApplication.class, args);
    }

}
