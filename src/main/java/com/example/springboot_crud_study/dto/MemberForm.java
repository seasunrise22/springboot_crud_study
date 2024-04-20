package com.example.springboot_crud_study.dto;

import com.example.springboot_crud_study.entity.Member;

public class MemberForm {
    private Long id;
    private String email;
    private String password;

    public MemberForm(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "MemberForm{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Member toEntity() {
        return new Member(id, email, password);
    }
}
