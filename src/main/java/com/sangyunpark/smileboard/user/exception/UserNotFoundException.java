package com.sangyunpark.smileboard.user.exception;

import com.sangyunpark.smileboard.user.error.UserErrorCode;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(UserErrorCode userErrorCode) {
        super(userErrorCode.getMessage());
    }
}
