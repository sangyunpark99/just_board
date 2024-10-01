package com.sangyunpark.smileboard.board.service;

import static com.sangyunpark.smileboard.board.error.PostErrorCode.*;
import static com.sangyunpark.smileboard.category.error.CategoryErrorCode.*;
import static com.sangyunpark.smileboard.user.error.UserErrorCode.*;

import com.sangyunpark.smileboard.board.domain.Post;
import com.sangyunpark.smileboard.board.dto.PostDto;
import com.sangyunpark.smileboard.board.dto.request.PostRegisterRequest;
import com.sangyunpark.smileboard.board.dto.request.PostUpdateRequest;
import com.sangyunpark.smileboard.board.exception.NotFoundPostException;
import com.sangyunpark.smileboard.board.exception.NotMatchUserException;
import com.sangyunpark.smileboard.board.repository.PostRepository;
import com.sangyunpark.smileboard.category.domain.Category;
import com.sangyunpark.smileboard.category.exception.CategoryNotFoundException;
import com.sangyunpark.smileboard.category.repository.CategoryRepository;
import com.sangyunpark.smileboard.user.domain.User;
import com.sangyunpark.smileboard.user.exception.UserNotFoundException;
import com.sangyunpark.smileboard.user.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public void register(final String userId, final PostRegisterRequest request) {

        User user = userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(
                USER_NOT_FOUND));

        Category category = categoryRepository.findByTitle(request.getCategory()).orElseThrow(() -> new CategoryNotFoundException(
                CATEGORY_NOT_FOUND));

        Post post = request.toEntity();

        post.addUser(user);
        post.addCategory(category);

        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<PostDto> getUserPosts(final String userId) {

        User user = userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        List<PostDto> posts = user.getPosts().stream().map(post -> post.toDto()).collect(Collectors.toList());

        return posts;
    }

    @Transactional
    public PostDto update(final String userId, final PostUpdateRequest request) {

        userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        Post post = postRepository.findById(request.getPostId()).orElseThrow(() -> new NotFoundPostException(POST_NOT_FOUND));

        final String title = request.getTitle() == null ? post.getTitle() : request.getTitle();
        final String content = request.getContent() == null ? post.getContents() : request.getContent();

        post.update(title, content, post.getType());

        return post.toDto();
    }

    @Transactional
    public void delete(final String userId, final Long postId) {

        User user = userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        Post post = postRepository.findById(postId).orElseThrow(() -> new NotFoundPostException(POST_NOT_FOUND));

        List<Post> posts = user.getPosts();

        if(!posts.contains(post)) {
            throw new NotMatchUserException(NOT_MATCH_USER);
        }

        post.removeRelation();

        postRepository.deleteById(postId);
    }
}
