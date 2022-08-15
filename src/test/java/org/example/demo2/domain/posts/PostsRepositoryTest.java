package org.example.demo2.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글_저장_불러오기() {
        String title = "테스트 제목";
        String contents = "테스트 본문";
        postsRepository.save(
                Posts.builder()
                .title(title)
                .contents(contents)
                .author("wbr76")
                .build()
        );

        //when
        List<Posts> postList = postsRepository.findAll();

        //then
        Posts posts = postList.get(0);
        assertThat(posts.getTitle().equals(title));
        assertThat(posts.getContents().equals(contents));

    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2022,8,15,0,0,0);
        postsRepository.save(
                Posts.builder()
                        .title("title")
                        .contents("contents")
                        .author("wbr76")
                        .build());
        //when
        List<Posts> postLists = postsRepository.findAll();

        Posts posts = postLists.get(0);

        System.out.println(">>>>>>>>>>> createDate="+posts.getCreateDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
