package com.example.springboot_crud_study.service;

import com.example.springboot_crud_study.dto.ArticleForm;
import com.example.springboot_crud_study.dto.CoffeeDto;
import com.example.springboot_crud_study.entity.Article;
import com.example.springboot_crud_study.entity.Coffee;
import com.example.springboot_crud_study.repository.ArticleRepository;
import com.example.springboot_crud_study.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service // 서비스 객체 생성
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository; // 커피 리파지터리 객체 주입

    public List<Coffee> index() {
        return coffeeRepository.findAll();
    }

    public Coffee show(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    public Coffee create(CoffeeDto dto) {
        if(dto.getId() != null) {
            return null;
        }
        Coffee coffee = dto.toEntity(); // 데이터 변환 로직
        return coffeeRepository.save(coffee); // 데이터베이스와의 상호작용
    }

    public Coffee update(Long id, CoffeeDto dto) {
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if(target == null || !id.equals(dto.getId())) {
            log.warn("coffee update failed, id is : " + id);
            return null;
        }
        target.patch(dto);
        return coffeeRepository.save(target);
    }

    public Coffee delete(Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);

        if(target == null) {
            log.warn("delete not working");
            return null;
        }
        coffeeRepository.delete(target);
        return target;
    }

//    @Transactional
//    public List<Article> createArticles(List<ArticleForm> dtos) {
//        List<Article> articleList = dtos.stream()
//                .map(dto -> dto.toEntity())
//                .collect(Collectors.toList());
//
//        articleList.stream()
//                .forEach(article -> articleRepository.save(article));
//
//        // 강제 예외 발생
//        articleRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("결제 실패!"));
//
//        return articleList;
//    }
}
