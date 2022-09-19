package com.example.boardproject.controller;

import com.example.boardproject.domain.MemberType;
import com.example.boardproject.dto.MemberDTO;
import com.example.boardproject.entity.Member;
import com.example.boardproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    //넘어오는 @ModelAttribute MemberDTO 는 없지만 th:object="${memberDTO}" 를 사용하기 위해 넣었다.
    @GetMapping("/new")
    public String signForm(@ModelAttribute("memberDTO") MemberDTO memberDTO) {
        return "signup";
    }

    @PostMapping("/new")
    public String signup(@Validated @ModelAttribute(name = "memberDTO") MemberDTO memberDTO, BindingResult bindingResult) {

        //이곳에서는 FieldError를 생성했으며 memberDTO의 loginId필드와 매핑된다.
        if (validationLoginId(memberDTO.getLoginId()).equals(memberDTO.getLoginId())) {
            bindingResult.addError(new FieldError("memberDTO","loginId","이미 존재하는 아이디입니다."));
        }

        //말그대로 Errors를 갖는다면 에러를 발생시키고 로그를 찍은 뒤 리턴한다.
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "signup";
        }

        Member member = new Member(memberDTO.getLoginId(), memberDTO.getPassword(), memberDTO.getMemberType());

        memberService.signup(member);

        return "redirect:/";
    }

    /**
     * 회원가입 시 아이디로 멤버를 찾는 메서드이다. 이 메서드의 리턴 값으로 로그인 시 중복인지 확인한다.
     * 위에 signup 메서드 코드 길이가 복잡해 따로 뺏다.
     */
    private String validationLoginId(String loginId) {
        Optional<Member> result = memberService.findByLoginId(loginId);
        log.info("result={}", result);
        return result.get().getLoginId();
    }

    /**
     * @ModelAttribute("memberType") 이와 같이 쓰면 view 페이지에 memberType라는 이름으로 프러퍼티가 넘어간다.
     */
    @ModelAttribute("memberType")
    public MemberType[] memberTypes() {
        return MemberType.values();
    }
}
