package com.sangyunpark.smileboard.category.service;

import static com.sangyunpark.smileboard.category.error.CategoryErrorCode.*;
import static com.sangyunpark.smileboard.user.error.UserErrorCode.USER_NOT_FOUND;

import com.sangyunpark.smileboard.category.domain.Category;
import com.sangyunpark.smileboard.category.dto.request.CategoryCreateRequest;
import com.sangyunpark.smileboard.category.dto.request.CategoryUpdateRequest;
import com.sangyunpark.smileboard.category.exception.CategoryNotFoundException;
import com.sangyunpark.smileboard.category.repository.CategoryRepository;
import com.sangyunpark.smileboard.user.exception.UserNotFoundException;
import com.sangyunpark.smileboard.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void register(final String userId, final CategoryCreateRequest request) {

        userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(
                USER_NOT_FOUND));

        Category category = request.toEntity();

        categoryRepository.save(category);
    }

    @Transactional
    public void update(final String userId, final Long categoryId, final CategoryUpdateRequest request) {

        userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(
                CATEGORY_NOT_FOUND));

        category.update(request.getTitle());
    }

    @Transactional
    public void delete(final String userId, final Long categoryId) {

        userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND));

        categoryRepository.delete(category);
    }
}