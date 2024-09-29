package com.sangyunpark.smileboard.user.dto.response;

import lombok.Getter;

@Getter
public class UserLoginResponse {

    private String message;

    public UserLoginResponse() {
        this.message = "로그인 성공";
    }
}
