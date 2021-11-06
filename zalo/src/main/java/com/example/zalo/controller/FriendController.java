package com.example.zalo.controller;

import com.example.zalo.entity.Friend;
import com.example.zalo.model.dto.CommentDTO;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.dto.PostDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateFriendRequest;
import com.example.zalo.model.request.CreatePostRequest;
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

    @PostMapping("/friendRequest/{userBId}")
    public ResponseEntity<?> createFriendRequest(@Valid @RequestBody CreateFriendRequest request, @PathVariable int userBId,Principal principal) {
        String username = principal.getName();
        UserDTO userDTO =userService.findByUserName(username);

         int userAId =userDTO.getId();

        FriendDTO result = friendService.createFriendRequest(request,userAId,userBId);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/friendRequest")
    public ResponseEntity<?> getAllFriendRequest( Principal principal){

        String username = principal.getName();
        UserDTO userDTO =userService.findByUserName(username);

        int userId = userDTO.getId();

        List<FriendDTO> friends = friendService.getAllFriendRequest(userId);
        return ResponseEntity.ok(friends);
    }

    @PutMapping("/friendRequest/{id}")
    public ResponseEntity<?> acceptFriendRequest( @PathVariable int id) {
        friendService.acceptFriendRequest(id);
        return ResponseEntity.ok("Accepted friend request");
    }

    @DeleteMapping("/friendRequest/{id}")
    public ResponseEntity<?> deleteFriendRequest(@PathVariable int id) {
        friendService.deleteFriendRequest(id);
        return ResponseEntity.ok("Deleted friend request");
    }

}
