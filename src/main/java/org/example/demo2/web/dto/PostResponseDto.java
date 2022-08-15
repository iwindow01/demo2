package org.example.demo2.web.dto;

import lombok.Getter;
import org.example.demo2.domain.posts.Posts;

import java.util.Optional;

@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String author;

    public PostResponseDto(Posts posts){

        this.id = posts.getId();
        this.title = posts.getTitle();
        this.contents = posts.getContents();
        this.author = posts.getAuthor();
    }
}
