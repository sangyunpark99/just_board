package com.sangyunpark.smileboard.user.domain;

import com.sangyunpark.smileboard.board.domain.Post;
import com.sangyunpark.smileboard.global.BaseEntity;
import com.sangyunpark.smileboard.user.dto.UserStatus;
import com.sangyunpark.smileboard.user.dto.UserType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickName;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    protected User() {

    }

    @Builder
    public User(final String userId, final String password, final String nickName, final UserType type,
                final UserStatus status) {
        this.userId = userId;
        this.password = password;
        this.nickName = nickName;
        this.type = type;
        this.status = status;
    }

    public void updatePassword(String password){
        this.password = password;
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}
