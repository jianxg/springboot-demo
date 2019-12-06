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
    public Object get(int id)
    {
        String sql = "SELECT * FROM \"Emp\" where \"Id\"=?";
        return jdbc.queryForList(sql, id);
    }

    @RequestMapping(value = "/add")
    public Object add(String name)
    {
        String sql = "INSERT INTO \"Emp\"(\"Name\") VALUES (?);";
        jdbc.update(sql,name);
        return "新增成功";
    }

    @RequestMapping(value = "/update")
    public Object update(int id ,String name)
    {
        String sql = "UPDATE \"Emp\" SET \"Name\"=? WHERE \"Id\"=?";
        System.err.println("delete");
        jdbc.update(sql,name,id);
        return "更新成功！";
    }

    @RequestMapping(value = "/delete")
    public Object delete(int id){
        String sql = "DELETE FROM \"Emp\" WHERE \"Id\"=?";
        jdbc.update(sql,id);
        return "删除成功！";
    }

    @RequestMapping(value = "/count")
    public Integer count( )
    {
        String sql = "SELECT count(*) FROM \"Emp\"  ;";
        Integer k=jdbc.queryForObject(sql, Integer.class);
        return	k;
    }
}
