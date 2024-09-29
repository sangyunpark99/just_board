package com.sangyunpark.smileboard.user.exception.errorCode;

import lombok.Getter;

@Getter
public enum ErrorCode {

    DUPLICATED_ID("중복된 아이디입니다."),
    USER_NOT_FOUND("존재하지 않는 사용자입니다."),

    SESSION_NOT_FOUND("세션을 찾을 수 없습니다.");

    String message;

    ErrorCode(final String message) {
        this.message = message;
    }
}
