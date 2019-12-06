package com.example.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @Autowired
    private JdbcTemplate jdbc;

    @RequestMapping(value = "/getDate")
    public Object get(int id){
        String sql = "SELECT * FROM \"Emp\" where \"Id\"=?";
        return jdbc.queryForList(sql, id);
    }
}
