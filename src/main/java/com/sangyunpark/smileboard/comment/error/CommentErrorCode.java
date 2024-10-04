package com.sangyunpark.smileboard.comment.error;

import lombok.Getter;

@Getter
public enum CommentErrorCode {
    COMMENT_NOT_FOUND("댓글을 찾을 수 없습니다.");

    String message;

    CommentErrorCode(final String message) {
        this.message = message;
    }
}
