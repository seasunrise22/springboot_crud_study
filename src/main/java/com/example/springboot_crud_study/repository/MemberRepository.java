package com.example.springboot_crud_study.repository;

import com.example.springboot_crud_study.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
