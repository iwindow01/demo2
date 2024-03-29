package org.example.demo2.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    private String title;
    private String contents;

    @Builder
    public PostUpdateRequestDto(String title,String contents){
        this.title = title;
        this.contents = contents;
    }
}
