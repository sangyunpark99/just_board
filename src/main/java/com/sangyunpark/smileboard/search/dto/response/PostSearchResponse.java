package com.sangyunpark.smileboard.search.dto.response;

import com.sangyunpark.smileboard.board.dto.PostDto;
import java.util.List;
import lombok.Getter;

@Getter
public class PostSearchResponse {

    private List<PostDto> posts;

    public PostSearchResponse(List<PostDto> posts) {
        this.posts = posts;
    }
}
