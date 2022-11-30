package com.example.hanghae3rd.service.posts;

import com.example.hanghae3rd.domain.posts.Posts;
import com.example.hanghae3rd.domain.posts.PostsRepository;
import com.example.hanghae3rd.web.dto.PostsResponseDto;
import com.example.hanghae3rd.web.dto.PostsSaveRequestDto;
import com.example.hanghae3rd.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    //게시글 저장
    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    //게시글 수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    //게시글 삭제
    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    //id에 해당하는 게시글 반환
    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    //모든 게시글 반환
    public List<PostsResponseDto> findAll(){
        List<Posts> entityList = postsRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        List<PostsResponseDto> postsList = new ArrayList<>();
        for(Posts entity : entityList){
            postsList.add(new PostsResponseDto(entity));
        }

        return postsList;
    }
}
