package com.example.zalo.controller;

import com.example.zalo.model.dto.BlockDTO;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.service.BlockService;
import com.example.zalo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
