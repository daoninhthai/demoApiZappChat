package com.example.zalo.model.mapper;


import com.example.zalo.entity.User;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        UserDTO tmp = new UserDTO();
        tmp.setId(user.getId());
        tmp.setUsername(user.getUsername());
        tmp.setFirstName(user.getFirstName());
        tmp.setLastName(user.getLastName());
        tmp.setGender(user.getGender());
        tmp.setJoinedDate(user.getJoinedDate());
        tmp.setDob(user.getDob());
        tmp.setLinkAvatar(user.getLinkAvatar());
        tmp.setPhoneNumber(user.getPhoneNumber());
        tmp.setAuthority(user.getAuthority().getAuthority());
        tmp.setStatus(user.getStatus());
        tmp.setPassword(user.getPassword());
        return tmp;
    }


    public static User toUser(CreateUserRequest request) {
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
