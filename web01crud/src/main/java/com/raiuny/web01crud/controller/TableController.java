package com.raiuny.web01crud.controller;

import com.raiuny.web01crud.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table() {

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        List<User> users = Arrays.asList(new User("张三","123456"),
                new User("李四","123"),
                new User("王五","1232")
                );
        model.addAttribute("users",users);
        return "table/dynamic_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }
}
