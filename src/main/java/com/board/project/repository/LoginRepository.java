package com.board.project.repository;

import com.board.project.entity.Member;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

public interface LoginRepository extends JpaRepository<Member, String>, QuerydslPredicateExecutor<Member> {



    @Query("select m from Member m where m.loginId =:loginId ")
    Optional<Member> findByLoginId(@Param("loginId") String loginId);


}

