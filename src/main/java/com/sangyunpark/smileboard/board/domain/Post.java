package com.sangyunpark.smileboard.board.domain;

import com.sangyunpark.smileboard.board.dto.PostDto;
import com.sangyunpark.smileboard.board.dto.PostWriterType;
import com.sangyunpark.smileboard.category.domain.Category;
import com.sangyunpark.smileboard.comment.domain.Comment;
import com.sangyunpark.smileboard.file.domain.File;
import com.sangyunpark.smileboard.global.BaseEntity;
import com.sangyunpark.smileboard.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
@Entity
public class Post extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private PostWriterType type;

    private String contents;

    private int viewCounts;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(mappedBy = "post")
    private List<File> files = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    protected Post() {

    }

    public Post(final String title, final PostWriterType type, final String contents) {
        this.title = title;
        this.type = type;
        this.contents = contents;
        this.viewCounts = 0;
    }

    public void update(final String title, final String contents, final PostWriterType type) {
        this.title = title;
        this.contents = contents;
        this.type = type;
    }

    public PostDto toDto() {

        return PostDto.builder()
                .id(this.id)
                .title(this.title)
                .content(this.contents)
                .type(this.type)
                .createdAt(this.getCreatedAt())
                .viewCounts(this.viewCounts)
                .categoryTitle(this.category.getTitle())
                .build();
    }

    public void addUser(User user) {
        this.user = user;
        user.addPost(this);
    }

    public void addCategory(Category category) {
        this.category = category;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.addPost(this);
    }

    public void removeRelation() {
        this.user.getPosts().remove(this);
        this.user = null;
        this.category.getPosts().remove(this);
        this.category = null;
    }
}
