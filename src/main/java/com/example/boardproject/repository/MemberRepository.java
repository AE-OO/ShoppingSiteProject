package com.example.boardproject.repository;

import com.example.boardproject.entity.Board;
import com.example.boardproject.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Integer> {

//    Optional<Member> findByLoginId(String loginId);
    @Query("select b from Member b where b.loginId=:loginId")
    Member findByLoginId(String loginId);
}
