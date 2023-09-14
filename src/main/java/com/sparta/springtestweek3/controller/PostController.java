package com.sparta.springtestweek3.controller;

import com.sparta.springtestweek3.dto.PostRequestDto;
import com.sparta.springtestweek3.dto.PostResponseDto;
import com.sparta.springtestweek3.dto.StatusResponseDto;
import com.sparta.springtestweek3.service.PostService;
import jdk.jshell.Snippet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 1. 판매 게시물 작성
    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto){
        return postService.createPost(postRequestDto);
    }

    // 2. 판매 게시글 전체 리스트 조회
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts(){
        return postService.getPosts();
    }

    // 3. 판매 게시글 상세 조회
    @GetMapping("/post/{id}")
    public PostResponseDto getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    // 4. 판매 게시글 수정
    @PutMapping("/post/{id}")
    public PostResponseDto updatePost(@RequestBody PostRequestDto postRequestDto, @PathVariable Long id){
        return postService.updatePost(postRequestDto, id);
    }

    // 5. 게시글 삭제
    @DeleteMapping("/post/{id}")
    public ResponseEntity<StatusResponseDto> deletePost(@PathVariable Long id){
        postService.deletePost(id);

        return ResponseEntity.ok(new StatusResponseDto("삭제완료"));
    }
}
