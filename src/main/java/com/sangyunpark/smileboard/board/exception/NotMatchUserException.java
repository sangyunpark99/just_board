package com.sangyunpark.smileboard.board.exception;

import com.sangyunpark.smileboard.board.error.PostErrorCode;

public class NotMatchUserException extends RuntimeException {

    public NotMatchUserException(PostErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
