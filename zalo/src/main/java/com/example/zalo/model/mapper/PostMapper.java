package com.example.zalo.model.mapper;

import com.example.zalo.entity.Post;
import com.example.zalo.entity.User;
import com.example.zalo.model.dto.PostDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateUserRequest;

public class PostMapper {
    public static PostDTO toPostDTO(Post post) {
        PostDTO tmp = new PostDTO();
        tmp.setId(post.getId());
        tmp.setContent(post.getContent());
        tmp.setMedia(post.getMedia());
        tmp.setUpdated(post.getUpdated());
        tmp.setAuthor(post.getAuthor().getId());
        return tmp;
    }


    public static User toPost(CreateUserRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setGender(request.getGender());
        user.setDob(request.getDob());
        user.setJoinedDate(request.getJoinedDate());
        user.setStatus(request.getStatus());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setLinkAvatar(request.getLinkAvatar());
        return user;
    }

}
