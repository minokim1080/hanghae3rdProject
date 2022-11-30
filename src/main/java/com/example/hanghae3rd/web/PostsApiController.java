package com.example.hanghae3rd.web;

import com.example.hanghae3rd.service.posts.PostsService;
import com.example.hanghae3rd.web.dto.PostsResponseDto;
import com.example.hanghae3rd.web.dto.PostsSaveRequestDto;
import com.example.hanghae3rd.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //게시글 전체 조회
    @GetMapping("/posts")
    public List<PostsResponseDto> showPosts(){
        return postsService.findAll();
    }

    //게시글 등록
    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //게시글 수정
    @PutMapping("/posts/{postId}")
    public Long updatePosts(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    //게시글 조회
    @GetMapping("/posts/{postId}")
    public PostsResponseDto showPostsDetail(@PathVariable Long id){
        return postsService.findById(id);
    }

    //게시글 삭제
    @DeleteMapping("/posts/{postId}")
    public Long deletePosts(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
