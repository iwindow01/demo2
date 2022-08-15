package org.example.demo2.web;

import lombok.RequiredArgsConstructor;
import org.example.demo2.service.posts.PostsService;
import org.example.demo2.web.dto.PostSaveRequestDto;
import org.example.demo2.web.dto.PostUpdateRequestDto;
import org.example.demo2.web.dto.PostResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private  final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

}

