package com.sangyunpark.smileboard.board.repository;

import com.sangyunpark.smileboard.board.domain.Post;
import com.sangyunpark.smileboard.category.domain.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<List<Post>> findByCategory(Category category);
}
