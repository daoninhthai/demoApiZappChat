package com.example.zalo.controller;

import com.example.zalo.model.dto.BlockDTO;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateBlockRequest;
import com.example.zalo.model.request.CreateFriendRequest;
import com.example.zalo.service.BlockService;
import com.example.zalo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class BlockController {
    private final BlockService blockService;
    private final UserService userService;
    public BlockController(BlockService blockService, UserService userService) {
        this.blockService = blockService;
        this.userService = userService;
    }
    @GetMapping("/block-chats")
    public ResponseEntity<?> getAllBlockChat(Principal principal){

        String username = principal.getName();
        UserDTO userDTO =userService.findByUserName(username);

        int userId = userDTO.getId();

        List<BlockDTO> blocks = blockService.getAllBlockChat(userId);
        return ResponseEntity.ok(blocks);
    }
    @GetMapping("/block-diary")
    public ResponseEntity<?> getAllBlockDiary( Principal principal){

        String username = principal.getName();
        UserDTO userDTO =userService.findByUserName(username);

        int userId = userDTO.getId();

        List<BlockDTO> blocks = blockService.getAllBlockDiary(userId);
        return ResponseEntity.ok(blocks);
    }

    @PostMapping("/blockChatRequest/{userBId}")
    public ResponseEntity<?> createBlockChatRequest( @PathVariable int userBId, Principal principal) {
        String username = principal.getName();
        UserDTO userDTO =userService.findByUserName(username);

        int userAId =userDTO.getId();

        blockService.createBlockChatRequest(userAId,userBId);
        return ResponseEntity.ok("Block chat successfully");
    }

    @PostMapping("/blockDiaryRequest/{userBId}")
    public ResponseEntity<?> createBlockDiaryRequest(@Valid @RequestBody CreateBlockRequest request, @PathVariable int userBId,Principal principal) {
        String username = principal.getName();
        UserDTO userDTO =userService.findByUserName(username);

        int userAId =userDTO.getId();

        blockService.createBlockDiaryRequest(request,userAId,userBId);
        return ResponseEntity.ok("Block diary successfully");
    }



    @DeleteMapping("/block/{id}")
    public ResponseEntity<?> deleteFriendRequest(@PathVariable int id) {
        blockService.deleteBlockRequest(id);
        return ResponseEntity.ok("Deleted block");
    }
}
