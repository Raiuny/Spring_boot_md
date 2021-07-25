package com.raiuny.web01crud.controller;

import com.raiuny.web01crud.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if(!StringUtils.isEmpty(user.getUsername())&& "12345".equals(user.password))
        {
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }
        else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    /**
     * 去main页面，重定向
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null)
        return "main";
        else {
            model.addAttribute("msg", "请重新登录");
            return "login";
        }
    }
}
