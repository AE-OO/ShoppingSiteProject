package com.example.boardproject.service;

import com.example.boardproject.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberService memberService;

    /**
     * Optional은 Stream과 같 filter메서드를 갖는다.
     * 로그인 아이디로 멤버를 찾고 패스워드가 같은지 equals로 검사한다.
     */
    public Member login(String loginId, String password){
        Optional<Member> byLoginId = memberService.findByLoginId(loginId);
//        Optional<Member> byLoginId1 = Optional.of(byLoginId);
        return byLoginId.filter(
                m -> m.getPassword().equals(password)).orElse(null);
    }
}
