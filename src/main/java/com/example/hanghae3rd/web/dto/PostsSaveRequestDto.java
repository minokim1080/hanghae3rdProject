package com.example.hanghae3rd.web.dto;

import com.example.hanghae3rd.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String author;
    private String password;
    private String content;

    @Builder
    public PostsSaveRequestDto(String title, String name, String password, String content){
        this.title = title;
        this.author = name;
        this.password = password;
        this.content = content;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .author(author)
                .password(password)
                .content(content)
                .build();
    }
}
