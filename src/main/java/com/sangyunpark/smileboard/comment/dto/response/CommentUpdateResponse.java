package com.sangyunpark.smileboard.comment.dto.response;

import com.sangyunpark.smileboard.comment.dto.CommentDto;
import lombok.Getter;

@Getter
public class CommentUpdateResponse {

    private String message;

    private CommentDto comment;

    public CommentUpdateResponse(CommentDto commentDto) {
        this.message = "댓글 수정 성공";
        this.comment = commentDto;
    }
}
