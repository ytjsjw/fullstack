package com.board.project.repository;

import com.board.project.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MemberRepository extends JpaRepository<Member, String>, QuerydslPredicateExecutor<Member> {


}
