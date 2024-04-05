package com.example.springboot_crud_study.controller;

import com.example.springboot_crud_study.dto.MemberForm;
import com.example.springboot_crud_study.entity.Member;
import com.example.springboot_crud_study.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUpPage() {
        return "members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm memberForm) {
        System.out.println(memberForm.toString());

        // 1. DTO를 엔티티로 변환
        Member member = memberForm.toEntity();
        System.out.println(member.toString());

        // 2. 리파지터리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        saved.toString();

        return "";
    }
}
