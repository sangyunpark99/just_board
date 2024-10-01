package com.sangyunpark.smileboard.board.dto.request;

import com.sangyunpark.smileboard.board.domain.Post;
import com.sangyunpark.smileboard.board.dto.PostWriterType;
import lombok.Getter;

@Getter
public class PostRegisterRequest {

    private String title;

    private PostWriterType type;

    private String content;

    private String category;

    public Post toEntity() {
        return new Post(title, type, content);
    }
}
