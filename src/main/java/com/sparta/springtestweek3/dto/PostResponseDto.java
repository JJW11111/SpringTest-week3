package com.sparta.springtestweek3.dto;

import com.sparta.springtestweek3.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public PostResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.price = post.getPrice();
        this.username = post.getUsername();
    }
}
