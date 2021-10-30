package com.example.zalo.service;

import com.example.zalo.model.dto.CommentDTO;
import com.example.zalo.model.dto.PostDTO;
import com.example.zalo.model.request.CreateCommentRequest;
import com.example.zalo.model.request.CreatePostRequest;
import com.example.zalo.model.request.UpdateCommentRequest;
import com.example.zalo.model.request.UpdatePostRequest;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    CommentDTO createComment(CreateCommentRequest request,int postId, int commentId);

    CommentDTO updateComment(UpdateCommentRequest request, int id);//id comment

    void deleteComment(int id);//id comment
}
