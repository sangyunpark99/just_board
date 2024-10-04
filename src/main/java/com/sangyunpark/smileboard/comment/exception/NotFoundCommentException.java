package com.sangyunpark.smileboard.comment.exception;

import com.sangyunpark.smileboard.comment.error.CommentErrorCode;

public class NotFoundCommentException extends RuntimeException{
    public NotFoundCommentException(CommentErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
