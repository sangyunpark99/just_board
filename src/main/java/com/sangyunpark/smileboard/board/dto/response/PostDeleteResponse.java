package com.sangyunpark.smileboard.board.dto.response;

import lombok.Getter;

@Getter
public class PostDeleteResponse{

    private String message;

    public PostDeleteResponse() {
        this.message = "게시물 삭제 완료";
    }
}
