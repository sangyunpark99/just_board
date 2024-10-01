package com.sangyunpark.smileboard.board.error;

import lombok.Getter;

@Getter
public enum PostErrorCode {

    POST_NOT_FOUND("존재하지 않는 게시문 입니다."),
    NOT_MATCH_USER("유저가 작성한 게시물이 아닙니다.");

    String message;

    PostErrorCode(final String message) {
        this.message = message;
    }
}
