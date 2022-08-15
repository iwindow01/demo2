package org.example.demo2.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.demo2.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String contents;
    private String author;
    @Builder
    public PostSaveRequestDto(String title,String contents,String author){
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .contents(contents)
                .author(author)
                .build();
    }
}
