package com.example.zalo.controller;

import com.example.zalo.model.dto.PostDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreatePostRequest;
import com.example.zalo.model.request.UpdatePostRequest;
import com.example.zalo.service.PostService;
import com.example.zalo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class PostController {
    private final PostService postService;
    private final UserService userService;
    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getAllPosts(){
        List<PostDTO> posts = postService.getAllPost();
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/posts")
    public ResponseEntity<?> createPost(@Valid @RequestBody CreatePostRequest request, Principal principal) {
        String username = principal.getName();
        UserDTO userDTO =userService.findByUserName(username);

        int authorId = userDTO.getId();
        PostDTO result = postService.createPost(request,authorId);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return ResponseEntity.ok("Deleted post");
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<?> updatePost(@Valid @RequestBody UpdatePostRequest request, @PathVariable int id) {
        PostDTO result = postService.updatePost(request, id);
        return ResponseEntity.ok(result);
    }


}
