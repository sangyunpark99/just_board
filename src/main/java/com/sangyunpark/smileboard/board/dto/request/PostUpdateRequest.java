package com.sangyunpark.smileboard.board.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PostUpdateRequest {

    @NotNull
    private Long postId;

    private String title;

    private String content;
}
