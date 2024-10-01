package com.sangyunpark.smileboard.board.controller;

import com.sangyunpark.smileboard.board.dto.PostDto;

import com.sangyunpark.smileboard.board.dto.response.PostDeleteResponse;
import com.sangyunpark.smileboard.board.dto.request.PostRegisterRequest;
import com.sangyunpark.smileboard.board.dto.request.PostUpdateRequest;
import com.sangyunpark.smileboard.board.dto.response.PostRegisterResponse;
import com.sangyunpark.smileboard.board.dto.response.PostUpdateResponse;
import com.sangyunpark.smileboard.board.dto.response.UserPostsResponse;
import com.sangyunpark.smileboard.board.service.PostService;
import com.sangyunpark.smileboard.user.aop.LoginCheck;
import com.sangyunpark.smileboard.user.dto.UserType;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @LoginCheck(type = UserType.DEFAULT)
    @PostMapping
    public ResponseEntity<PostRegisterResponse> register(String userId, @Valid @RequestBody PostRegisterRequest request) {

        postService.register(userId, request);

        return ResponseEntity.ok().body(new PostRegisterResponse());
    }

    @LoginCheck(type = UserType.DEFAULT)
    @GetMapping
    public ResponseEntity<UserPostsResponse> usersPost(final String userId) {

        List<PostDto> posts = postService.getUserPosts(userId);

        return ResponseEntity.ok().body(new UserPostsResponse(posts));
    }

    @LoginCheck(type = UserType.DEFAULT)
    @PatchMapping
    public ResponseEntity<PostUpdateResponse> update(String userId, @Valid @RequestBody PostUpdateRequest request) {

        PostDto postDto = postService.update(userId, request);

        return ResponseEntity.ok().body(new PostUpdateResponse(postDto));
    }

    @LoginCheck(type = UserType.DEFAULT)
    @DeleteMapping("{postId}")
    public ResponseEntity<PostDeleteResponse> delete(String userId, @PathVariable("postId") Long postId) {

        postService.delete(userId, postId);

        return ResponseEntity.ok().body(new PostDeleteResponse());
    }

}
