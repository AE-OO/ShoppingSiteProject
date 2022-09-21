package com.example.boardproject.service;

import com.example.boardproject.entity.Member;

import java.util.Optional;

public interface MemberService {

    Member signup(Member member);

    Member findById(int id);

//    Member findByLoginId(String loginId);
    Optional<Member> findByLoginId(String loginId);
}
