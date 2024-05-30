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
    @ManyToOne // 이러한 어노테이션을 사용하면 해당 필드는 연관된 엔티티의 객체로 매핑 됨. 테이블에서는 article_id가 나오지만, 객체를 받아오면 연관된 article 객체가 받아와짐.
    @JoinColumn(name = "article_id") // 외래키 생성, Article 엔티티의 기본키(id)와 매핑
    private Article article;
    @Column
    private String nickname;
    @Column
    private String body;
}
