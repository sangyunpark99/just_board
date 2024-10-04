package com.sangyunpark.smileboard.comment.controller;

import com.sangyunpark.smileboard.comment.dto.CommentDto;
import com.sangyunpark.smileboard.comment.dto.request.CommentRegisterRequest;
import com.sangyunpark.smileboard.comment.dto.request.CommentUpdateRequest;
import com.sangyunpark.smileboard.comment.dto.response.CommentDeleteResponse;
import com.sangyunpark.smileboard.comment.dto.response.CommentInfoResponse;
import com.sangyunpark.smileboard.comment.dto.response.CommentRegisterResponse;
import com.sangyunpark.smileboard.comment.dto.response.CommentUpdateResponse;
import com.sangyunpark.smileboard.comment.service.CommentService;
import com.sangyunpark.smileboard.user.aop.LoginCheck;
import com.sangyunpark.smileboard.user.dto.UserType;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @LoginCheck(type = UserType.DEFAULT)
    public ResponseEntity<CommentRegisterResponse> register(String userId, @Valid @RequestBody CommentRegisterRequest request) {
        CommentDto commentDto = commentService.register(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommentRegisterResponse(commentDto));
    }

    @GetMapping("/{postId}")
    @LoginCheck(type = UserType.DEFAULT)
    public ResponseEntity<CommentInfoResponse> get(String userId, @PathVariable("postId") Long postId) {
        List<CommentDto> comments = commentService.get(userId, postId);
        return ResponseEntity.ok(new CommentInfoResponse(comments));
    }

    @PatchMapping
    @LoginCheck(type = UserType.DEFAULT)
    public ResponseEntity<CommentUpdateResponse> update(String userId, @Valid @RequestBody CommentUpdateRequest request) {
        CommentDto commentDto = commentService.update(userId, request);
        return ResponseEntity.ok(new CommentUpdateResponse(commentDto));
    }

    @DeleteMapping("/{commentId}")
    @LoginCheck(type = UserType.DEFAULT)
    public ResponseEntity<CommentDeleteResponse> delete(String userId, @PathVariable("commentId") Long commentId) {
        commentService.delete(userId, commentId);
        return ResponseEntity.ok(new CommentDeleteResponse());
    }
}
