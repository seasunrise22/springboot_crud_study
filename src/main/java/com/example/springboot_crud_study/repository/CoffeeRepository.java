package com.example.springboot_crud_study.repository;

import com.example.springboot_crud_study.entity.Article;
import com.example.springboot_crud_study.entity.Coffee;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {

    @Override
    ArrayList<Coffee> findAll();
}
