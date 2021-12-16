package com.example.zalo.service.impl;

import com.example.zalo.entity.Post;
import com.example.zalo.entity.User;
import com.example.zalo.exception.InternalServerException;
import com.example.zalo.exception.NotFoundException;
import com.example.zalo.model.dto.PostDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.mapper.PostMapper;
import com.example.zalo.model.mapper.UserMapper;
import com.example.zalo.model.request.CreatePostRequest;
import com.example.zalo.model.request.UpdatePostRequest;
import com.example.zalo.repository.PostRepository;
import com.example.zalo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<Post> posts =postRepository.findAll();
        List<PostDTO> result = new ArrayList<>();
        for (Post post:posts){
            result.add(PostMapper.toPostDTO(post));
        }
        return result;
    }

    @Override
    public List<PostDTO> getAllUserPost(int authorId) {
        List<Post> posts =postRepository.findPostByUserId(authorId);
        List<PostDTO> result = new ArrayList<>();
        for (Post post:posts){
            result.add(PostMapper.toPostDTO(post));
        }
        return result;
    }

    @Override
    public PostDTO getPostById(int id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new NotFoundException("No post found");
        }
        return PostMapper.toPostDTO(post.get());
    }
    @Override
    public PostDTO createPost(CreatePostRequest request,int authorId) {
        Post post = new Post();
        User user = new User();
        user.setId(authorId);
        post = PostMapper.toPost(request);
        post.setAuthor(user);
        postRepository.save(post);

        return PostMapper.toPostDTO(post);
    }

    @Override
    public PostDTO updatePost(UpdatePostRequest request, int id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new NotFoundException("No post found");
        }

        Post updatePost = PostMapper.toPost(request, id);
        updatePost.setAuthor(post.get().getAuthor());
        try {
            postRepository.save(updatePost);
        } catch (Exception ex) {
            throw new InternalServerException("Can't update post");
        }

        return PostMapper.toPostDTO(updatePost);
    }

    @Override
    public void deletePost(int id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new NotFoundException("No post found");
        }

        try {
            postRepository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalServerException("Can't delete post");
        }
    }
}
