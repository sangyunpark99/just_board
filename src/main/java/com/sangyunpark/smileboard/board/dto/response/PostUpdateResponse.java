package com.sangyunpark.smileboard.board.dto.response;

import com.sangyunpark.smileboard.board.dto.PostDto;
import lombok.Getter;

@Getter
public class PostUpdateResponse {

    private PostDto post;

    public PostUpdateResponse(PostDto postDto) {

        this.post = postDto;
    }
}
