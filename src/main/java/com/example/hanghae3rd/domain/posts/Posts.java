package com.example.hanghae3rd.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 256, nullable = false)
    private String pw; //해쉬로 반영해서 넣을 수 있으면 변경

    @Column(columnDefinition = "TEXT")
    private String content;

    @Builder
    public Posts(String title, String name, String pw, String content){
        this.title = title;
        this.name = name;
        this.pw = pw;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
