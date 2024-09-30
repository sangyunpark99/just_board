package com.sangyunpark.smileboard.category.dto.response;

import lombok.Getter;

@Getter
public class CategoryDeleteResponse {

    private String message;

    public CategoryDeleteResponse() {
        this.message = "카테 고리 삭제 성공";
    }
}
