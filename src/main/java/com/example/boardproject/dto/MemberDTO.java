package com.example.boardproject.dto;

import com.example.boardproject.domain.MemberType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * javax.validation.constraints은 javax가 써있다. 자바진형에서 제공하는 자바표준이다.
 * 위의 기능과 확장된 기능을 제공하는 스프링버전도 있다.
 * build.gradle에 밑에 기재한 의존성을 추가해야 쓸 수 있다.
 * implementation 'org.springframework.boot:spring-boot-starter-validation'
 */
@Data
public class MemberDTO {

    @NotBlank(message = "아이디를 입력하세요")
    @Length(min = 3, max = 20, message = "3-20자리를 입력하세요")
    private String loginId;

    @NotBlank(message = "비밀번호를 입력하세요")
    @Length(min = 3, max = 20, message = "3-20자리를 입력하세요")
    private String password;

    @NotNull(message = "필수값입니다")
    private MemberType memberType;
}
