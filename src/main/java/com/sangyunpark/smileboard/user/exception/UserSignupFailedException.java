package com.sangyunpark.smileboard.user.exception;

import static com.sangyunpark.smileboard.user.error.ErrorCode.USER_SIGNUP_FAILED;

public class UserSignupFailedException extends RuntimeException{
    public UserSignupFailedException() {
        super(USER_SIGNUP_FAILED.getMessage());
    }
}
