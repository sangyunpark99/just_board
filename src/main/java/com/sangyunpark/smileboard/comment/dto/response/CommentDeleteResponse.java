package com.sangyunpark.smileboard.comment.dto.response;

import lombok.Getter;

@Getter
public class CommentDeleteResponse {

    private String message;

    public CommentDeleteResponse() {
        this.message = "댓글 삭제 성공";
    }
}
