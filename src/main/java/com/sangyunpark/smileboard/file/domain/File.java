package com.sangyunpark.smileboard.file.domain;

import com.sangyunpark.smileboard.board.domain.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class File {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String filePath;

    private FileType fileType;

    @JoinColumn(name = "post_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

}
