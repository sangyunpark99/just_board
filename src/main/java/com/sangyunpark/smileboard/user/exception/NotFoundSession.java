package com.sangyunpark.smileboard.user.exception;

import com.sangyunpark.smileboard.user.exception.errorCode.ErrorCode;

public class NotFoundSession extends RuntimeException{

    public NotFoundSession(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
