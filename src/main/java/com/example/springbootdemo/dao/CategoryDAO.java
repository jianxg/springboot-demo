package com.example.springbootdemo.dao;

import com.example.springbootdemo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
