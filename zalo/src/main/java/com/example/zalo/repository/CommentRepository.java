package com.example.zalo.repository;


import com.example.zalo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.security.Principal;

public interface CommentRepository  extends JpaRepository<Comment, Integer> {



}
