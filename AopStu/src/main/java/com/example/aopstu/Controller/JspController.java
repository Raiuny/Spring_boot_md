package com.example.aopstu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
    @RequestMapping("jsp")
    public String jspController() {
        return "index";
    }
}
