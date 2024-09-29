package com.sangyunpark.smileboard.user.dto.response;

import lombok.Getter;

@Getter
public class UserLogoutResponse {

    private String message;

    public UserLogoutResponse() {
        this.message = "로그 아웃 성공";
    }
}
