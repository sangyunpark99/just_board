package com.sangyunpark.smileboard.search.service;

import static com.sangyunpark.smileboard.board.error.PostErrorCode.*;
import static com.sangyunpark.smileboard.category.error.CategoryErrorCode.*;

import com.sangyunpark.smileboard.board.domain.Post;
import com.sangyunpark.smileboard.board.dto.PostDto;
import com.sangyunpark.smileboard.board.exception.NotFoundPostException;
import com.sangyunpark.smileboard.board.repository.PostRepository;
import com.sangyunpark.smileboard.category.domain.Category;
import com.sangyunpark.smileboard.category.exception.NotFoundCategoryException;
import com.sangyunpark.smileboard.category.repository.CategoryRepository;
import com.sangyunpark.smileboard.search.dto.request.SearchCategoryRequest;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchService {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;

    @Cacheable(value = "getPostsByCategory", key = "'getPostsByCategory' + #request.category + #request.id")
    @Transactional
    public List<PostDto> getPostsByCategory(SearchCategoryRequest request) {

        Category findCategory = categoryRepository.findByTitle(request.getCategory()).orElseThrow(() -> new NotFoundCategoryException(
                CATEGORY_NOT_FOUND));

        List<Post> posts = postRepository.findByCategory(findCategory).orElseThrow(() -> new NotFoundPostException(POST_NOT_FOUND));

        List<PostDto> postDtos = posts.stream().map(post -> PostDto.fromEntity(post)).collect(Collectors.toList());

        return postDtos;
    }
}
