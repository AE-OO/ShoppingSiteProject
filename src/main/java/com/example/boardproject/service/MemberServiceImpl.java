package com.example.boardproject.service;

import com.example.boardproject.entity.Member;
import com.example.boardproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
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
        log.info("loginId={}",loginId);
        Member findMember = memberRepository.findByLoginId(loginId);
        log.info("findMember={}",findMember);
        return Optional.ofNullable(findMember);
    }
}
