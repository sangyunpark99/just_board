package com.sangyunpark.smileboard.category.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    protected Category(){

    }

    @Builder
    public Category(final String title) {
        this.title = title;
    }

    public void update(final String title) {
        this.title = title;
    }
}