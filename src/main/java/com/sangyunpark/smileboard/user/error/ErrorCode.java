package com.sangyunpark.smileboard.user.error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    DUPLICATE_ID("중복된 아이디 입니다."),
    USER_SIGNUP_FAILED("회원가입에 실패 했습니다"),
    NOT_EXISTED_USER("존재 하지 않는 사용자 입니다."),
    NOT_EQUAL_PASSWORD("비밀번호가 일치하지 않습니다.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
