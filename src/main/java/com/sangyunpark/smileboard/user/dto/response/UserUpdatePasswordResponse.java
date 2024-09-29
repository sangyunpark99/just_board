package com.sangyunpark.smileboard.user.dto.response;

import lombok.Getter;

@Getter
public class UserUpdatePasswordResponse {

    private String message;

    public UserUpdatePasswordResponse() {
        this.message = "비밀 번호 변경 성공";
    }
}
