package com.sangyunpark.smileboard.category.error;

import lombok.Getter;

@Getter
public enum CategoryErrorCode {

    CATEGORY_NOT_FOUND("찾을 수 없는 카테고리 입니다.");

    String message;

    CategoryErrorCode(final String message) {
        this.message = message;
    }
}
