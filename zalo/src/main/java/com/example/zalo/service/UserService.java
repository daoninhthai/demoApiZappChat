package com.example.zalo.service;

import java.security.Principal;
import java.util.List;


import com.example.zalo.entity.User;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateUserRequest;
import org.springframework.stereotype.Service;




@Service
public interface UserService {

    List<UserDTO> getAllUser();

    UserDTO findByUserName(String username);

    User findUserByUsername(String username);

    UserDTO getUserById(int id);

    int getCurrentUserId(Principal principal);

//    UserDTO updateUser(UpdateUserRequest request, int id);
//
//    UserDTO disableUser(UpdateUserRequest request, int id);
//
    UserDTO createUser(CreateUserRequest request);

//    UserDTO changePassword(ChangePasswordRequest request, String username);


}
