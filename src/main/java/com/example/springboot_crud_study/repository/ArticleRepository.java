package com.example.springboot_crud_study.repository;

import com.example.springboot_crud_study.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
