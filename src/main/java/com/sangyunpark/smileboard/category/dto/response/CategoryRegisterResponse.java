package com.sangyunpark.smileboard.category.dto.response;

import lombok.Getter;

@Getter
public class CategoryRegisterResponse {

    private String message;

    public CategoryRegisterResponse() {
        this.message = "카테 고리 등록 성공";
    }
}
