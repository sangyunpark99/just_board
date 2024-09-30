package com.sangyunpark.smileboard.category.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CategoryUpdateRequest {

    @NotBlank
    private String title;

}
