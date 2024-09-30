package com.sangyunpark.smileboard.user.error;

import lombok.Getter;

@Getter
public enum UserErrorCode {

    DUPLICATED_ID("중복된 아이디 입니다."),
    USER_NOT_FOUND("존재하지 않는 사용자 입니다."),

    SESSION_NOT_FOUND("세션을 찾을 수 없습니다.");

    String message;

    UserErrorCode(final String message) {
        this.message = message;
    }
}
