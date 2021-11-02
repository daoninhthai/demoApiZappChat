package com.example.zalo.controller;

import com.example.zalo.model.dto.CommentDTO;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.dto.PostDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.UpdatePostRequest;
import com.example.zalo.service.FriendService;
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
public class FriendController {
    private final FriendService friendService;
    private final UserService userService;
    @Autowired
    public FriendController(FriendService friendService, UserService userService) {
        this.friendService = friendService;
        this.userService = userService;
    }

    @GetMapping("/friends")
    public ResponseEntity<?> getAllFriend( Principal principal){

        String username = principal.getName();
        UserDTO userDTO =userService.findByUserName(username);

        int userId = userDTO.getId();

        List<FriendDTO> friends = friendService.getAllFriend(userId);
        return ResponseEntity.ok(friends);
    }

    @GetMapping("/friends/requests")
    public ResponseEntity<?> getAllFriendRequest( Principal principal){

        String username = principal.getName();
        UserDTO userDTO =userService.findByUserName(username);

        int userId = userDTO.getId();

        List<FriendDTO> friends = friendService.getAllFriendRequest(userId);
        return ResponseEntity.ok(friends);
    }

    @PutMapping("/friends/requests/{id}")
    public ResponseEntity<?> acceptFriendRequest( @PathVariable int id) {
        friendService.acceptFriendRequest(id);
        return ResponseEntity.ok("Accepted friend request");
    }

    @DeleteMapping("/friends/requests/{id}")
    public ResponseEntity<?> deleteFriendRequest(@PathVariable int id) {
        friendService.deleteFriendRequest(id);
        return ResponseEntity.ok("Deleted friend request");
    }

}
