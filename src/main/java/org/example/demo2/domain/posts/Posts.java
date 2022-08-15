package org.example.demo2.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.demo2.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",  nullable = false)
    private String contents;

    private String author;

    @Builder
    public Posts(String title, String contents, String author){
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    public void update(String title,String contents){
        this.title = title;
        this.contents = contents;
    }
}
