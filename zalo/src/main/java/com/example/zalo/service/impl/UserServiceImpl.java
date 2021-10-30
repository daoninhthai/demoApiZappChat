package com.example.zalo.service.impl;

import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.example.zalo.entity.Authority;
import com.example.zalo.entity.User;
import com.example.zalo.exception.NotFoundException;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.mapper.UserMapper;
import com.example.zalo.model.request.CreateUserRequest;
import com.example.zalo.repository.UserRepository;
import com.example.zalo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> getAllUser() {

        List<User> users = userRepository.findByStatus("enabled");
        List<UserDTO> result = new ArrayList<>();
        for (User user : users) {
            result.add(UserMapper.toUserDTO(user));
        }
        return result;
    }

    @Override
    public UserDTO findByUserName(String username) {
        User user = userRepository.findByUsername(username);
        return UserMapper.toUserDTO(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDTO getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("No user found");
        }
        return UserMapper.toUserDTO(user.get());
    }

    @Override
    public int getCurrentUserId(Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        int id = user.getId();
        return id;
    }

    @Override
    public UserDTO createUser(CreateUserRequest request) {

        User user = userRepository.findByUsername(request.getUsername());
        long count = userRepository.count() + 1;

        user = UserMapper.toUser(request);


        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("ddMMyyyy");
        String dob = user.getDob().format(formatters);

        user.setStatus("enabled");
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Authority authority = new Authority();
        authority.setAuthority(request.getAuthority());
        authority.setUser(user);

        user.setAuthority(authority);
        userRepository.saveAndFlush(user);
        return UserMapper.toUserDTO(user);
    }


}
