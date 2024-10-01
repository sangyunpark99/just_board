package com.sangyunpark.smileboard.search.controller;

import com.sangyunpark.smileboard.board.dto.PostDto;
import com.sangyunpark.smileboard.search.dto.request.SearchCategoryRequest;
import com.sangyunpark.smileboard.search.dto.response.PostSearchResponse;
import com.sangyunpark.smileboard.search.service.SearchService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/{category}")
    public ResponseEntity<PostSearchResponse> getPostsByCategory(@Valid @RequestBody SearchCategoryRequest request) {

        List<PostDto> posts = searchService.getPostsByCategory(request);

        return ResponseEntity.ok(new PostSearchResponse(posts));
    }
}
