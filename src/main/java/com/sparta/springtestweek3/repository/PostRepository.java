package com.sparta.springtestweek3.repository;

import com.sparta.springtestweek3.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
