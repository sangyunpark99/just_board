package com.sangyunpark.smileboard.user.exception;

import com.sangyunpark.smileboard.user.error.UserErrorCode;

public class DuplicatedIdException extends RuntimeException {

    public DuplicatedIdException(UserErrorCode userErrorCode) {
        super(userErrorCode.getMessage());
    }
}
