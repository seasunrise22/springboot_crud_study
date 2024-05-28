package com.example.springboot_crud_study.service;

import com.example.springboot_crud_study.entity.Article;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}