package com.sangyunpark.smileboard.user.exception;

import static com.sangyunpark.smileboard.user.error.ErrorCode.*;

public class NotEqualPassword extends RuntimeException{
    public NotEqualPassword() {
        super(NOT_EQUAL_PASSWORD.getMessage());
    }
}
