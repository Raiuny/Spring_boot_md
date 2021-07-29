package com.example.aopstu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@SpringBootTest
class AopStuApplicationTests {
    @Autowired
    @Qualifier("cala")
    private Calendar c1;
    @Test
    void calendar_test() {
        System.out.println(c1.getTime());
    }
    @Test
    void test_Injectobj() {

    }
}
