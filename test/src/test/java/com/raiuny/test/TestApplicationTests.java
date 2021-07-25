package com.raiuny.test;

import com.raiuny.test.bean.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


/**
 * SpringBoot单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入容器的功能
 */
@SpringBootTest
class TestApplicationTests {
    @Autowired
    Person person1;

    @Test
    void contextLoads() {
        System.out.println(person1);
    }

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService(){
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void out_log(){
        logger.trace("这是trace日志");
        logger.info("这是info日志");
        logger.debug("这是debug日志");
        logger.error("error logging");



    }

}
