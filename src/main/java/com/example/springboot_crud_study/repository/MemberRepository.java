package com.example.springboot_crud_study.repository;

import com.example.springboot_crud_study.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MemberRepository extends CrudRepository<Member, Long> {

    @Override
    ArrayList<Member> findAll();
}
