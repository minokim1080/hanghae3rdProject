package com.example.hanghae3rd.web;

import com.example.hanghae3rd.service.posts.PostsService;
import com.example.hanghae3rd.web.dto.PostsResponseDto;
import com.example.hanghae3rd.web.dto.PostsSaveRequestDto;
import com.example.hanghae3rd.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //게시글 전체 조회
    @GetMapping("/api/posts")
    public List<PostsResponseDto> showPosts(){
        return postsService.findAll();
    }

    //게시글 등록
    @PostMapping("/api/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //게시글 수정
    @PutMapping("/api/posts/{id}")
    public PostsResponseDto updatePosts(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        postsService.update(id, requestDto);
        return postsService.findById(id);
    }

    //게시글 조회
    @GetMapping("/api/posts/{id}")
    public PostsResponseDto showPostsDetail(@PathVariable Long id){
        return postsService.findById(id);
    }

    //게시글 삭제, 추후 Map부분 리팩토링 할 예정
    @DeleteMapping("/api/posts/{id}")
    public Map<String,Boolean> deletePosts(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        postsService.delete(id, requestDto);
        Map<String,Boolean> message = new HashMap<>();
        message.put("success",true);
        return message;
    }
}
