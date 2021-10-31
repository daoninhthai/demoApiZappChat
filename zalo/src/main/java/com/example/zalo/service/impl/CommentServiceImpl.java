package com.example.zalo.service.impl;

import com.example.zalo.entity.Comment;
import com.example.zalo.entity.Post;
import com.example.zalo.entity.User;
import com.example.zalo.exception.InternalServerException;
import com.example.zalo.exception.NotFoundException;
import com.example.zalo.model.dto.CommentDTO;
import com.example.zalo.model.mapper.CommentMapper;
import com.example.zalo.model.request.CreateCommentRequest;
import com.example.zalo.model.request.UpdateCommentRequest;
import com.example.zalo.repository.CommentRepository;
import com.example.zalo.service.CommentService;
import com.example.zalo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
@Service
public class CommentServiceImpl implements CommentService {


    private final CommentRepository commentRepository;

    private  final UserService userService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    @Override
    public CommentDTO createComment(CreateCommentRequest request, int postId ,int commentatorId) {
        Comment comment = new Comment();
        User user =new User();
        user.setId(commentatorId);
        Post post = new Post();
        post.setId(postId);
        comment = CommentMapper.toComment(request,postId);
        comment.setPost(post);
        comment.setUser(user);
        commentRepository.save(comment);

        return CommentMapper.toCommentDTO(comment);
    }

    @Override
    public CommentDTO updateComment(UpdateCommentRequest request, int id) {
        Optional<Comment> comment= commentRepository.findById(id);
        if (comment.isEmpty()) {
            throw new NotFoundException("No comment found");
        }

        Comment updateComment = CommentMapper.toComment(request, id);
        try {
            commentRepository.save(updateComment);
        } catch (Exception ex) {
            throw new InternalServerException("Can't update comment");
        }

        return CommentMapper.toCommentDTO(updateComment);
    }

    @Override
    public void deleteComment(int id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isEmpty()) {
            throw new NotFoundException("No comment found");
        }

        try {
            commentRepository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalServerException("Can't delete comment");
        }
    }
}
