package com.example.zalo.controller;

import com.example.zalo.entity.User;
import com.example.zalo.model.dto.CommentDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateCommentRequest;
import com.example.zalo.model.request.CreatePostRequest;
import com.example.zalo.service.CommentService;
import com.example.zalo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;
    @Autowired
    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }


    @PostMapping("/comments/post/{id}")
    public ResponseEntity<?> createComment(@Valid @RequestBody CreateCommentRequest request, @PathVariable int id, Principal principal) {
        String username = principal.getName();
        UserDTO userDTO =userService.findByUserName(username);

        int commentatorId = userDTO.getId();

        CommentDTO result = commentService.createComment(request,id,commentatorId);
        return ResponseEntity.ok(result);
    }
}
