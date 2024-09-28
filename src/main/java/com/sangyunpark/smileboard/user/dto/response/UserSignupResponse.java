package com.sangyunpark.smileboard.user.dto.response;

import lombok.Getter;

@Getter
public class UserSignupResponse {

    private String message;

    public UserSignupResponse() {
        this.message = "회원 가입 성공";
    }
}
