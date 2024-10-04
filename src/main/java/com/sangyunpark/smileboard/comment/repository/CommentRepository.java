package com.sangyunpark.smileboard.comment.repository;

import com.sangyunpark.smileboard.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
