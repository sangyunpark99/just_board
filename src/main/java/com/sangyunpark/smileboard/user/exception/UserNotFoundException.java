package com.sangyunpark.smileboard.user.exception;

import com.sangyunpark.smileboard.user.exception.errorCode.ErrorCode;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
