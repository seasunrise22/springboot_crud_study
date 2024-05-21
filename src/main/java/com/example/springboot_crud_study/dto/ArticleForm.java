package com.example.springboot_crud_study.dto;

import com.example.springboot_crud_study.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(title, content);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
