package com.sangyunpark.smileboard.category.dto;

import lombok.Getter;

@Getter
public class CategoryDto {

    private int id;
    private String name;

    public CategoryDto(final int id, final String name) {
        this.id = id;
        this.name = name;
    }
}
