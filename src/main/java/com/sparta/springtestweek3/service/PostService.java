package com.sparta.springtestweek3.service;

import com.sparta.springtestweek3.dto.PostRequestDto;
import com.sparta.springtestweek3.dto.PostResponseDto;
import com.sparta.springtestweek3.entity.Post;
import com.sparta.springtestweek3.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 1. 판매 게시물 작성
    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        Post savePost = postRepository.save(post);

        return new PostResponseDto(savePost);
    }

    // 2. 판매 게시글 전체 리스트 조회
    public List<PostResponseDto> getPosts() {
        return postRepository.findAll().stream().map(PostResponseDto::new).toList();
    }

    // 3. 판매 게시글 상세 조회
    public PostResponseDto getPostById(Long id) {
        Post post = findPost(id);

        return new PostResponseDto(post);
    }

    @Transactional
    // 4. 판매 게시글 수정
    public PostResponseDto updatePost(PostRequestDto postRequestDto, Long id) {
        Post post = findPost(id);
        post.update(postRequestDto);

        return new PostResponseDto(post);
    }

    // 5. 게시글 삭제
    public void deletePost(Long id) {
        Post post = findPost(id);

        postRepository.delete(post);
    }

    // 해당 Id 게시물 찾기
    private Post findPost(Long id){
        return postRepository.findById(id).orElseThrow();
    }


}
