package com.example.springboot_crud_study.dto;

import com.example.springboot_crud_study.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public ArticleForm(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(id, title, content);
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    /*public Long getId() {
        return id;
    }*/

    /*@Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "ArticleForm{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
