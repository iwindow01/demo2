package org.example.demo2.service.posts;

import lombok.RequiredArgsConstructor;
import org.example.demo2.domain.posts.Posts;
import org.example.demo2.domain.posts.PostsRepository;
import org.example.demo2.web.dto.PostSaveRequestDto;
import org.example.demo2.web.dto.PostUpdateRequestDto;
import org.example.demo2.web.dto.PostResponseDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 개시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContents());

        return id;
    }

    public PostResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 개시글이 없습니다. id="+id));

        return new PostResponseDto(entity);
    }
}
