package com.sangyunpark.smileboard.category.controller;

import static com.sangyunpark.smileboard.user.dto.UserType.*;

import com.sangyunpark.smileboard.category.dto.request.CategoryCreateRequest;
import com.sangyunpark.smileboard.category.dto.request.CategoryUpdateRequest;
import com.sangyunpark.smileboard.category.dto.response.CategoryDeleteResponse;
import com.sangyunpark.smileboard.category.dto.response.CategoryRegisterResponse;
import com.sangyunpark.smileboard.category.dto.response.CategoryUpdateResponse;
import com.sangyunpark.smileboard.category.service.CategoryService;
import com.sangyunpark.smileboard.user.aop.LoginCheck;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @LoginCheck(type = ADMIN)
    public ResponseEntity<CategoryRegisterResponse> registerCategory(String userId,
                                                                     @Valid @RequestBody CategoryCreateRequest request) {
        categoryService.register(userId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CategoryRegisterResponse());
    }

    @PatchMapping("{categoryId}")
    @LoginCheck(type = ADMIN)
    public ResponseEntity<CategoryUpdateResponse> updateCategories(String userId,
                                                                   @PathVariable(name = "categoryId") Long categoryId,
                                                                   @Valid @RequestBody  CategoryUpdateRequest request) {
        categoryService.update(userId,categoryId,request);

        return ResponseEntity.ok().body(new CategoryUpdateResponse());
    }

    @DeleteMapping("{categoryId}")
    @LoginCheck(type = ADMIN)
    public ResponseEntity<CategoryDeleteResponse> deleteCategories(String userId,
                                                                   @PathVariable(name = "categoryId") Long categoryId) {

        categoryService.delete(userId, categoryId);

        return ResponseEntity.ok().body(new CategoryDeleteResponse());
    }
}