package com.sangyunpark.smileboard.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CommentRegisterRequest {

    @NotNull
    private Long postId;

    @NotBlank
    private String contents;
}
