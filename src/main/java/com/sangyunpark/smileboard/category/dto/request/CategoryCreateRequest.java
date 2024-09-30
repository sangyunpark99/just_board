package com.sangyunpark.smileboard.category.dto.request;

import com.sangyunpark.smileboard.category.domain.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CategoryCreateRequest {

    @NotBlank
    private String title;

    public Category toEntity(){
        return Category.builder()
                .title(title)
                .build();
    }
}
