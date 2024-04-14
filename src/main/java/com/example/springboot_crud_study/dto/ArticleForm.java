package com.example.springboot_crud_study.dto;

import com.example.springboot_crud_study.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

public class ArticleForm {
    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(null, title, content);
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
