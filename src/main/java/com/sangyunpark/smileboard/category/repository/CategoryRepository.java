package com.sangyunpark.smileboard.category.repository;

import com.sangyunpark.smileboard.category.domain.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long id);

    Optional<Category> findByTitle(String title);

    void deleteById(Long id);
}
