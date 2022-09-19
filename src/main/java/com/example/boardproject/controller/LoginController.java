package com.example.boardproject.controller;

import com.example.boardproject.dto.LoginDTO;
import com.example.boardproject.entity.Member;
import com.example.boardproject.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String test(@ModelAttribute("loginDTO") LoginDTO loginDTO) {
        return "loginForm";
    }

    /**
     * @Validated은 DTO와 같은 클래스 필드에 @NotNull과 같은 validation을 맵핑해준다.
     * BindingResult는 항상 필시 @ModelAttribute 뒤에 와야하며 @ModelAttribute로 넘어온 값을 바인딩하여 저장하고 이를 검증하고 에러를 발생시킨다.
     */
    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("loginDTO") LoginDTO loginDTO, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "loginForm";
        }
        //login 메서드는 값이 있다면 loginMember를 없다면 orElse(null)를 통해 Null을 반환한다.
        Member loginMember = loginService.login(loginDTO.getLoginId(), loginDTO.getPassword());

        //앞선 login메서드가 Null을 반환할 경우 bindingResult가 에러를 발생시킨다.
        if (loginMember == null) {
            bindingResult.addError(new ObjectError("loginDTO" , "로그인에 실패했습니다."));
            return "loginForm";
        }

        //세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 저장
        session.setAttribute("loginMember", loginMember);


        return "redirect:/";
    }
    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        //request에 세션을 가져온다. create가 디폴트는 true라 false로 잡았다.
        HttpSession session = request.getSession(false);

        //세션이 존재하면 세션 무효
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
