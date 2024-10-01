package com.sangyunpark.smileboard.category.domain;

import com.sangyunpark.smileboard.board.domain.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "category")
    private List<Post> posts;

    protected Category(){

    }

    @Builder
    public Category(final String title) {
        this.title = title;
    }

    public void update(final String title) {
        this.title = title;
    }
}