package com.example.springbootdemo.controller;

import com.example.springbootdemo.common.ResultMessage;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RequestMapping(value = "/api")
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin(origins = {"http://localhost:8080", "null"})
    @RequestMapping("login")
    @ResponseBody
    public ResultMessage UserLogin(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return new ResultMessage(400);
        } else {
            return new ResultMessage(200);
        }
    }
}
