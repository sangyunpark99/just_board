package com.sangyunpark.smileboard.board.dto;

import com.sangyunpark.smileboard.board.domain.Post;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostDto {

    private Long id;

    private String title;

    private PostWriterType type;

    private String content;

    private LocalDateTime createdAt;

    private int viewCounts;

    private String categoryTitle;

    @Builder
    public PostDto(final Long id, final String title, final PostWriterType type, final String content,
                   final LocalDateTime createdAt, final int viewCounts, final String categoryTitle) {

        this.id = id;
        this.title = title;
        this.type = type;
        this.content = content;
        this.createdAt = createdAt;
        this.viewCounts = viewCounts;
        this.categoryTitle = categoryTitle;
    }

    public static PostDto fromEntity(Post post) {
        return PostDto.builder()
                .title(post.getTitle())
                .content(post.getContents())
                .type(post.getType())
                .createdAt(post.getCreatedAt())
                .viewCounts(post.getViewCounts())
                .categoryTitle(post.getCategory().getTitle())
                .build();
    }
}
