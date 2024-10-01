package com.sangyunpark.smileboard.file.repository;

import com.sangyunpark.smileboard.file.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
