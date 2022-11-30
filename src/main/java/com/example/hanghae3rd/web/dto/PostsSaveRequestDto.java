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
    private String name;
    private String pw;
    private String content;

    @Builder
    public PostsSaveRequestDto(String title, String name, String pw, String content){
        this.title = title;
        this.name = name;
        this.pw = pw;
        this.content = content;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .name(name)
                .pw(pw)
                .content(content)
                .build();
    }
}
