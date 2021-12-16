package com.example.zalo.repository;

import com.example.zalo.entity.Post;
import com.example.zalo.entity.User;
import com.example.zalo.model.dto.PostDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "SELECT * FROM post WHERE author_id = ?1 ", nativeQuery = true)
    List<Post> findPostByUserId(int id);
}
