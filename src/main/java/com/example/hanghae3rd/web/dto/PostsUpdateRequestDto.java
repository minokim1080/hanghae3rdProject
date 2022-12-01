package com.example.hanghae3rd.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;

    @Builder
    public PostsUpdateRequestDto(String title, String content, String author, String password){
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    @Builder
    public PostsUpdateRequestDto(String password){
        this.password = password;
    }
}
