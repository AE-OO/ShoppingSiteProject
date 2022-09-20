package com.example.boardproject.service;

import com.example.boardproject.entity.Member;
import com.example.boardproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member signup(Member member) {
        return memberRepository.save(member);
    }

    //필요 시 정의
    @Override
    public Member findById(int id) {
        return null;
    }
    //로그인 아이디로 유저를 찾는다.
    @Override
    public Optional<Member> findByLoginId(String loginId) {
        Optional<Member> result = memberRepository.findByLoginId(loginId);
        return Optional.ofNullable(result.get());
    }
}