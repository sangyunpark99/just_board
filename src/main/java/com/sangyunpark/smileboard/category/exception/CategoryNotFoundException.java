package com.sangyunpark.smileboard.category.exception;

import com.sangyunpark.smileboard.category.error.CategoryErrorCode;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(CategoryErrorCode code) {
        super(code.getMessage());
    }
}
