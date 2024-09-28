package com.sangyunpark.smileboard.user.exception;

import com.sangyunpark.smileboard.user.exception.errorCode.ErrorCode;

public class DuplicatedIdException extends RuntimeException {

    public DuplicatedIdException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
