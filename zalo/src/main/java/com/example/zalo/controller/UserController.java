package com.example.zalo.controller;

import java.security.Principal;
import java.util.List;
import javax.validation.Valid;

import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateUserRequest;
import com.example.zalo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAllPosts(){
        List<UserDTO> posts = userService.getAllUser();
        return ResponseEntity.ok(posts);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDTO result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }



    @GetMapping("/my-info")
    public ResponseEntity<?> getUserByUsername(Principal principal) {
        String username = principal.getName();
        UserDTO result = userService.findByUserName(username);
        return ResponseEntity.ok(result);
    }



    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserDTO result = userService.createUser(request);
        return ResponseEntity.ok(result);
    }


}
