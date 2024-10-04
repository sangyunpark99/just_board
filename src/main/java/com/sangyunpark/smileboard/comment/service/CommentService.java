package com.sangyunpark.smileboard.comment.service;

import static com.sangyunpark.smileboard.board.error.PostErrorCode.POST_NOT_FOUND;
import static com.sangyunpark.smileboard.comment.error.CommentErrorCode.COMMENT_NOT_FOUND;
import static com.sangyunpark.smileboard.user.error.UserErrorCode.USER_NOT_FOUND;

import com.sangyunpark.smileboard.board.domain.Post;
import com.sangyunpark.smileboard.board.exception.NotFoundPostException;
import com.sangyunpark.smileboard.board.repository.PostRepository;
import com.sangyunpark.smileboard.comment.domain.Comment;
import com.sangyunpark.smileboard.comment.dto.CommentDto;
import com.sangyunpark.smileboard.comment.dto.request.CommentRegisterRequest;
import com.sangyunpark.smileboard.comment.dto.request.CommentUpdateRequest;
import com.sangyunpark.smileboard.comment.exception.NotFoundCommentException;
import com.sangyunpark.smileboard.comment.repository.CommentRepository;
import com.sangyunpark.smileboard.user.exception.UserNotFoundException;
import com.sangyunpark.smileboard.user.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentDto register(final String userId, final CommentRegisterRequest request) {
        userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(
                USER_NOT_FOUND));

        Post post = postRepository.findById(request.getPostId()).orElseThrow(() -> new NotFoundPostException(
                POST_NOT_FOUND));

        Comment comment = Comment.builder()
                .contents(request.getContents())
                .post(post).build();

        Comment savedComment = commentRepository.save(comment);

        return CommentDto.fromEntity(savedComment);
    }

    @Transactional(readOnly = true)
    public List<CommentDto> get(final String userId, final Long postId) {
        userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        Post post = postRepository.findById(postId).orElseThrow(() -> new NotFoundPostException(
                POST_NOT_FOUND));

        List<Comment> comments = post.getComments();

        List<CommentDto> commentDtos = comments.stream().map(comment -> CommentDto.fromEntity(comment)).collect(Collectors.toList());

        return commentDtos;
    }

    @Transactional
    public CommentDto update(final String userId, final CommentUpdateRequest commentUpdateRequest) {
        userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        Comment comment = commentRepository.findById(commentUpdateRequest.getCommentId()).orElseThrow(() -> new NotFoundCommentException(
                COMMENT_NOT_FOUND));

        comment.update(commentUpdateRequest.getContents());

        return CommentDto.fromEntity(comment);
    }

    @Transactional
    public void delete(final String userId, final Long commentId) {

        userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        commentRepository.findById(commentId).orElseThrow(() -> new NotFoundCommentException(
                COMMENT_NOT_FOUND));

        commentRepository.deleteById(commentId);
    }
}
