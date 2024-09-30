package com.sangyunpark.smileboard.category.dto.response;

import com.sangyunpark.smileboard.category.dto.request.CategoryUpdateRequest;
import lombok.Getter;

@Getter
public class CategoryUpdateResponse {

    private String message;

    public CategoryUpdateResponse() {
        this.message = "카테 고리 변경 성공";
    }
}
