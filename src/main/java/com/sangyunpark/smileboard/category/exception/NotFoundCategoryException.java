package com.sangyunpark.smileboard.category.exception;

import com.sangyunpark.smileboard.category.error.CategoryErrorCode;

public class NotFoundCategoryException extends RuntimeException {
    public NotFoundCategoryException(CategoryErrorCode code) {
        super(code.getMessage());
    }
}
