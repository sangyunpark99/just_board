package com.sangyunpark.smileboard.board.repository;

import com.sangyunpark.smileboard.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
