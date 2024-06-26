package com.example.springboot_crud_study.repository;

import com.example.springboot_crud_study.entity.Article;
import com.example.springboot_crud_study.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1: 4번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long articleId = 4L;
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 3. 예상 데이터
            Article article = new Article(4L, "알리 사세 가라아게 공구 ㄱ", "ㄱㄱ");
            Comment a = new Comment(1L, article, "ㅇㅇ", "탑승 완료");
            Comment b = new Comment(2L, article, "행인", "탑승 완료2");
            Comment c = new Comment(3L, article, "히히", "탑승 완료3");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력!");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1: "Park"의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            String nickname = "ㅇㅇ";
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByNickname(nickname);
            // 3. 예상 데이터
            Comment a = new Comment(1L, new Article(4L, "알리 사세 가라아게 공구 ㄱ", "ㄱㄱ"), nickname, "탑승 완료");
            Comment b = new Comment(4L, new Article(5L, "이거 뭐냐?", "뭐임?"), nickname, "고슴도치 같은데");
            Comment c = new Comment(7L, new Article(6L, "책 팝니다.", "얼마 안 봤어요."), nickname, "얼만가요?");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString());
        }
    }
}