package com.example.restful_app.controller.v1;

import com.example.restful_app.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/users")
public class UserController {
    @GetMapping("/{id}")
    //@PathVariable代表在路径中获取请求参数
    public ResponseEntity<User> user(@PathVariable("id") Integer id) {
        log.info("本次id:{}",id);
        User user = new User(21,"xiaoming",223.1,new Date());
        return new ResponseEntity<>(user, HttpStatus.OK);

    }


    @GetMapping
    public List<User> users() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(22,"小黑",21234.12,new Date()));
        users.add(new User(13,"小白",21234.12,new Date()));
        return users;
    }

    //添加用户
    @PostMapping
    public void saveUser(@RequestBody User user) {
        log.info("用户名称：{}，用户工资：{}，用户生日：{}",user.getName(),
                user.getSalary(), user.getBir());
    }

    //更新表
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody User user) {
        log.info("id:{}, 用户名称：{}，用户工资：{}，用户生日：{}",
                id,user.getName(),user.getSalary(),user.getBir());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        log.info("删除id为{}的用户", id);
    }
}
