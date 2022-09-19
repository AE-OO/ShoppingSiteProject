package com.example.boardproject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 로그인 시 값을 대조하기 위한 DTO다.
 */
@Data
public class LoginDTO {
    @NotBlank
    private String loginId;
    @NotBlank
    private String password;
}
