package com.example.hanghae3rd.web.dto;

import com.example.hanghae3rd.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String name;
    private String pw;
    private String content;
    private LocalDateTime createdAt;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.name = entity.getName();
        this.pw = entity.getPw();
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt();
    }
}
