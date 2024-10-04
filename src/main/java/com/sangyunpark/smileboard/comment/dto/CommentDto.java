package com.sangyunpark.smileboard.comment.dto;

import com.sangyunpark.smileboard.comment.domain.Comment;
import lombok.Getter;

@Getter
public class CommentDto {

    private Long id;
    private Long postId;
    private String contents;

    public CommentDto(final Long id, final Long postId, final String contents) {
        this.id = id;
        this.postId = postId;
        this.contents = contents;
    }

    public static CommentDto fromEntity(Comment comment) {
        return new CommentDto(comment.getId(), comment.getPost().getId(), comment.getContents());
    }
}
