package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Test")
@EnableAutoConfiguration
public class UserController {

    @RequestMapping("getUser")
    public User getUser()
    {
        User user=new User();
        user.setName("zhangsan");
        return user;
    }

}
