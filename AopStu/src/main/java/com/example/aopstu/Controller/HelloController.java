package com.example.aopstu.Controller;

import com.example.aopstu.Aop.Cal;
import com.example.aopstu.InjectOBJ.InjectObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    @Qualifier(value = "calImpl")
    private Cal cal;

    @Autowired
    private InjectObj o;
    @RequestMapping("demo")
    public String demo() {
        System.out.println(cal.add(2,3));
        return o.toString();
    }
}
