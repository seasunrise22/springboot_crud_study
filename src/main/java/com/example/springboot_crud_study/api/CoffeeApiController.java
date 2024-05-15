package com.example.springboot_crud_study.api;

import com.example.springboot_crud_study.dto.ArticleForm;
import com.example.springboot_crud_study.dto.CoffeeDto;
import com.example.springboot_crud_study.entity.Article;
import com.example.springboot_crud_study.entity.Coffee;
import com.example.springboot_crud_study.repository.ArticleRepository;
import com.example.springboot_crud_study.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CoffeeApiController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    // GET
    @GetMapping("/api/coffees") // 전체 게시글 조회
    public List<Coffee> index() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/api/coffees/{id}") // 단일 게시글 조회
    public Coffee show(@PathVariable Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("/api/coffees")
    public Coffee create(@RequestBody CoffeeDto dto) {
        Coffee coffee = dto.toEntity();
        return coffeeRepository.save(coffee);
    }

    // PATCH
    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeDto dto) {
//        Article article = dto.toEntity(); // 수정용 엔티티 생성
//        log.info("id: {}, article: {}", id, article.toString());
        log.info("id: {}", id);

        // DB에 해당 엔티티가 있는지 조회
        Coffee target = coffeeRepository.findById(id).orElse(null);

        // 대상 엔티티가 없거나 수정하려는 id가 잘못됐을 경우 처리
//        if(target == null || !id.equals(article.getId())) {
        if(target == null || !id.equals(dto.getId())) {
            // 400, 잘못된 요청 응답
//            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
            log.info("잘못된 요청! id: {}, dto: {}", id, dto.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // 대상 엔티티가 있으면 수정 내용으로 업데이트하고 정상 응답(200) 보내기
        target.patch(dto); // 기존 데이터에 새 데이터 갱신하기
        Coffee updated = coffeeRepository.save(target); // 수정 내용 DB에 최종 저장
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    // DELETE
    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if(target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        coffeeRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build(); // body(null)과 동일
    }
}
