package com.raiuny.springboot_mybatis.controller;

import com.raiuny.springboot_mybatis.utils.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletOutputStream;

@Controller
@RequestMapping("user")
public class UserRegController {
//    生成验证码方法
    @RequestMapping("generateImageCode")
    public void generateImageCode() {
//生成图片，然后通过response响应图片
//        String code = VerifyCodeUtils.generateVerifyCode(4);
//       session.setAttribute("code",code);
//        ServletOutputStream os = response.getOutputStream();
//        VerifyCodeUtils.outputImage(220,80,os, code);
        session
    }

}
