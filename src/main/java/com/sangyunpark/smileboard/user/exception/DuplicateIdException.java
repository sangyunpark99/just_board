package com.sangyunpark.smileboard.user.exception;

import static com.sangyunpark.smileboard.user.error.ErrorCode.*;

public class DuplicateIdException extends RuntimeException {
    public DuplicateIdException(){
        super(DUPLICATE_ID.getMessage());
    }
}
