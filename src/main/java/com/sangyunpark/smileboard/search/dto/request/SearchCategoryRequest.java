package com.sangyunpark.smileboard.search.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SearchCategoryRequest {

    @NotNull
    private Long id;

    @NotBlank
    private String category;
}
