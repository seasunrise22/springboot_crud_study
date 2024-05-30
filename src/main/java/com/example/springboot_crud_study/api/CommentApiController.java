package com.example.springboot_crud_study.api;

import com.example.springboot_crud_study.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;
    // 1. 댓글 조회
    // 2. 댓글 생성
    // 3. 댓글 수정
    // 4. 댓글 삭제
}
