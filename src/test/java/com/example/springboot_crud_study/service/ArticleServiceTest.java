package com.example.springboot_crud_study.service;

import com.example.springboot_crud_study.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // 예상 데이터
        Article a = new Article("가가가가", "1111");
        Article b = new Article("나나나나", "2222");
        Article c = new Article("다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제 데이터
        List<Article> articles = articleService.index();

        // 비교 및 검증
//        assertEquals(expected, articles);
        assertThat(articles)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .isEqualTo(expected);
    }

    @Test
    void show_success() {
        Long id = 1L;

        // 예상 데이터
        Article expected = new Article("가가가가", "1111");

        // 실제 데이터
        Article article = articleService.show(id);

        // 비교 및 검증
        assertThat(article)
                .usingRecursiveComparison().ignoringFields("id")
                .isEqualTo(expected);
    }

    @Test
    void show_fail() {
        Long id = -1L;

        // 예상 데이터
        Article expected = null;

        // 실제 데이터
        Article article = articleService.show(id);

        // 비교 및 검증
//        assertThat(article)
//                .usingRecursiveComparison().ignoringFields("id")
//                .isEqualTo(expected);
        assertThat(article).isNull();
    }
}