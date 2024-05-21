package com.example.springboot_crud_study.service;

import com.example.springboot_crud_study.dto.ArticleForm;
import com.example.springboot_crud_study.entity.Article;
import com.example.springboot_crud_study.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service // 서비스 객체 생성
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository; // 게시글 리파지터리 객체 주입

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity(); // 데이터 변환 로직
        if(article.getId() != null) {
            return null;
        }
        return articleRepository.save(article); // 데이터베이스와의 상호작용
    }

    public Article update(Long id, ArticleForm dto) {
        Article target = articleRepository.findById(id).orElse(null);
        if(target == null || !id.equals(dto.getId())) {
            log.warn("update failed, id is : " + id);
            return null;
        }
        target.patch(dto);
        return articleRepository.save(target);
    }
}
