package com.example.zalo.repository;

import com.example.zalo.entity.Post;
import com.example.zalo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
