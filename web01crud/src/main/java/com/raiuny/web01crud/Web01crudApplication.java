package com.raiuny.web01crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@ServletComponentScan(basePackages = "com.raiuny.web01crud")
@SpringBootApplication
public class Web01crudApplication {

    public static void main(String[] args) {

        SpringApplication.run(Web01crudApplication.class, args);
    }

}
