package com.sangyunpark.smileboard.user.exception;

import com.sangyunpark.smileboard.user.error.UserErrorCode;

public class NotFoundSession extends RuntimeException{

    public NotFoundSession(UserErrorCode userErrorCode) {
        super(userErrorCode.getMessage());
    }
}
