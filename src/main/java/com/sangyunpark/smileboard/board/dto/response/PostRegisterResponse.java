package com.sangyunpark.smileboard.board.dto.response;

import lombok.Getter;

@Getter
public class PostRegisterResponse {

    private String message;

    public PostRegisterResponse() {
        this.message = "게시물 등록 성공";
    }
}
