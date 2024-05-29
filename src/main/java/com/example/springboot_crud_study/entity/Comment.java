package com.example.springboot_crud_study.entity;

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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "article_id") // 외래키 생성, Article 엔티티의 기본키(id)와 매핑
    private Article article;
    @Column
    private String nickname;
    @Column
    private String body;
}
