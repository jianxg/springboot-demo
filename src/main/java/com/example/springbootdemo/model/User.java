package com.example.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
/*PostgreSQL中，您必须指定架构名称，如下所示：*/
@Table(name = "user",schema = "public")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String password;
    String username;

    public int getId()
    {
        return id;
    }

    public  void setId(int setId)
    {
        this.id=setId;
    }

    public String getPassword()
    {
        return  password;
    }

    public void setPassword(String setPassword)
    {
        this.password=setPassword;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String setUsername)
    {
        this.username=setUsername;
    }

}
