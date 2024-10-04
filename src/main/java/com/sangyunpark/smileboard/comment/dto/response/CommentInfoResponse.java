package com.sangyunpark.smileboard.comment.dto.response;

import com.sangyunpark.smileboard.comment.dto.CommentDto;
import java.util.List;
import lombok.Getter;

@Getter
public class CommentInfoResponse {

    private List<CommentDto> comments;

    public CommentInfoResponse(List<CommentDto> comments) {
        this.comments = comments;
    }
}
