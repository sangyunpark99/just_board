package com.sangyunpark.smileboard.comment.domain;

import com.sangyunpark.smileboard.board.domain.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @OneToMany(mappedBy = "comment")
    List<SubComment> subComments = new ArrayList<>();

    public void addPost(Post post) {
        this.post = post;
    }

    @Builder
    public Comment(final String contents, final Post post) {
        this.contents = contents;
        this.post = post;
        post.addComment(this);
    }

    public void update(final String contents) {
        this.contents = contents;
    }
}
