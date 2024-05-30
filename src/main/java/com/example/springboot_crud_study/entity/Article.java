package com.example.springboot_crud_study.entity;

import com.example.springboot_crud_study.dto.ArticleForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    //    public void patch(Article article) {
    public void patch(ArticleForm dto) {
        if (dto.getTitle() != null) {
            this.title = dto.getTitle();
        }

        if (dto.getContent() != null) {
            this.content = dto.getContent();
        }
    }
}
