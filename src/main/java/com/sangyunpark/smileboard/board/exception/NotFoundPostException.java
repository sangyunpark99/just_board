package com.sangyunpark.smileboard.board.exception;

import com.sangyunpark.smileboard.board.error.PostErrorCode;

public class NotFoundPostException extends RuntimeException {

    public NotFoundPostException(PostErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
