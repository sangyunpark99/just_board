package com.sangyunpark.smileboard.board.dto.response;

import com.sangyunpark.smileboard.board.dto.PostDto;
import java.util.List;
import lombok.Getter;

@Getter
public class UserPostsResponse {

    private List<PostDto> posts;

    public UserPostsResponse(final List<PostDto> posts) {
        this.posts = posts;
    }
}
