package com.sangyunpark.smileboard.comment.dto.response;

import com.sangyunpark.smileboard.comment.dto.CommentDto;
import lombok.Getter;

@Getter
public class CommentRegisterResponse {

    private String message;

    private CommentDto comment;

    public CommentRegisterResponse(CommentDto commentDto) {
        this.message = "댓글 등록 성공";
        this.comment = commentDto;
    }
}
