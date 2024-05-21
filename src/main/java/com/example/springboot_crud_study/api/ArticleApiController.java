package com.example.springboot_crud_study.api;

import com.example.springboot_crud_study.dto.ArticleForm;
import com.example.springboot_crud_study.entity.Article;
import com.example.springboot_crud_study.repository.ArticleRepository;
import com.example.springboot_crud_study.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {
    @Autowired
    private ArticleService articleService; // 서비스 객체 주입

    // 전체 게시글 조회
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleService.index();
    }

    // 단일 게시글 조회
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }

    // 게시글 생성 요청
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        Article created = articleService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 게시글 수정 요청
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
        Article updated = articleService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

//    // DELETE
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<?> delete(@PathVariable Long id) {
//        Article target = articleRepository.findById(id).orElse(null);
//
//        if(target == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        articleRepository.delete(target);
//        return ResponseEntity.status(HttpStatus.OK).build(); // body(null)과 동일
//    }






    //    @Autowired
//    private ArticleRepository articleRepository;
//
//    // GET
//    @GetMapping("/api/articles") // 전체 게시글 조회
//    public List<Article> index() {
//        return articleRepository.findAll();
//    }
//
//    @GetMapping("/api/articles/{id}") // 단일 게시글 조회
//    public Article show(@PathVariable Long id) {
//        return articleRepository.findById(id).orElse(null);
//    }
//
//    // POST
//    @PostMapping("/api/articles")
//    public Article create(@RequestBody ArticleForm dto) {
//        Article article = dto.toEntity();
//        return articleRepository.save(article);
//    }
//
//    // PATCH
//    @PatchMapping("/api/articles/{id}")
//    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
////        Article article = dto.toEntity(); // 수정용 엔티티 생성
////        log.info("id: {}, article: {}", id, article.toString());
//        log.info("id: {}", id);
//
//        // DB에 해당 엔티티가 있는지 조회
//        Article target = articleRepository.findById(id).orElse(null);
//
//        // 대상 엔티티가 없거나 수정하려는 id가 잘못됐을 경우 처리
////        if(target == null || !id.equals(article.getId())) {
//        if(target == null || !id.equals(dto.getId())) {
//            // 400, 잘못된 요청 응답
////            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
//            log.info("잘못된 요청! id: {}, dto: {}", id, dto.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        // 대상 엔티티가 있으면 수정 내용으로 업데이트하고 정상 응답(200) 보내기
//        target.patch(dto); // 기존 데이터에 새 데이터 갱신하기
//        Article updated = articleRepository.save(target); // 수정 내용 DB에 최종 저장
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }
//
//    // DELETE
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<?> delete(@PathVariable Long id) {
//        Article target = articleRepository.findById(id).orElse(null);
//
//        if(target == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        articleRepository.delete(target);
//        return ResponseEntity.status(HttpStatus.OK).build(); // body(null)과 동일
//    }
}
