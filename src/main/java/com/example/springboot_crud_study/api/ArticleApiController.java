package com.example.springboot_crud_study.api;

import com.example.springboot_crud_study.dto.ArticleForm;
import com.example.springboot_crud_study.entity.Article;
import com.example.springboot_crud_study.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleApiController {
    @Autowired
    private ArticleRepository articleRepository;
    // GET
    @GetMapping("/api/articles") // 전체 게시글 조회
    public List<Article> index() {
        return articleRepository.findAll();
    }

    @GetMapping("/api/articles/{id}") // 단일 게시글 조회
    public Article show(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto) {
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }
    // PATCH
    // DELETE
}
