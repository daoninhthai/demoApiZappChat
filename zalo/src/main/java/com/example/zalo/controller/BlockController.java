package com.example.zalo.controller;

import com.example.zalo.exception.BadRequestException;
import com.example.zalo.exception.DuplicateRecordException;
import com.example.zalo.model.dto.BlockDTO;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateBlockRequest;
import com.example.zalo.model.request.CreateFriendRequest;
import com.example.zalo.service.BlockService;
import com.example.zalo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Map;

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

        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userId = userDTO.getId();

        List<BlockDTO> blocks = blockService.getAllBlockChat(userId);
        return ResponseEntity.ok(blocks);
    }
    @GetMapping("/block-diary")
    public ResponseEntity<?> getAllBlockDiary( Principal principal){

        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userId = userDTO.getId();

        List<BlockDTO> blocks = blockService.getAllBlockDiary(userId);
        return ResponseEntity.ok(blocks);
    }

    @PostMapping("/blockChatRequest/{userBId}")
    public ResponseEntity<?> createBlockChatRequest( @PathVariable int userBId, Principal principal) {
        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userAId =userDTO.getId();
        try{
          blockService.createBlockChatRequest(userAId,userBId);
          return ResponseEntity.ok("Block chat successfully");
      }
        catch (BadRequestException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "code", "1004",
                    "message", "Parameter value is invalid",
                    "note","Không thể block bản thân "
            ));
        }
        catch (DuplicateRecordException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                    "code", "1004",
                    "message", "Action has been done previously by this user",
                    "note","Bạn đã block người này rồi "
            ));
        }
    }

    @PostMapping("/blockDiaryRequest/{userBId}")
    public ResponseEntity<?> createBlockDiaryRequest(@PathVariable int userBId,Principal principal) {
        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userAId =userDTO.getId();
    try {
        blockService.createBlockDiaryRequest(userAId,userBId);
        return ResponseEntity.ok("Block diary successfully");
    }
    catch (BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "code", "1004",
                "message", "Parameter value is invalid",
                "note","Không thể block bản thân "
        ));
    }
    catch (DuplicateRecordException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                "code", "1004",
                "message", "Action has been done previously by this user",
                "note","Bạn đã block người này rồi "
        ));
    }

    }

    @PostMapping("/blockUserRequest/{userBId}")
    public ResponseEntity<?> createBlockUserRequest( @PathVariable int userBId,Principal principal) {
        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userAId =userDTO.getId();
try{
    blockService.createBlockUserRequest(userAId,userBId);
    return ResponseEntity.ok("Block user successfully");
}
catch (BadRequestException e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "code", "1004",
            "message", "Parameter value is invalid",
            "note","Không thể block bản thân "
    ));
}
catch (DuplicateRecordException e){
    return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
            "code", "1004",
            "message", "Action has been done previously by this user",
            "note","Bạn đã block người này rồi "
    ));
}

    }

    @PostMapping("/blockUserCommentRequest/{userBId}")
    public ResponseEntity<?> createBlockUserCommentRequest( @PathVariable int userBId,Principal principal) {
        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userAId =userDTO.getId();

        try{
            blockService.createBlockUserCommentRequest(userAId,userBId);
            return ResponseEntity.ok("Block user comment successfully");
        }
        catch (BadRequestException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "code", "1004",
                    "message", "Parameter value is invalid",
                    "note","Không thể block bản thân "
            ));
        }
        catch (DuplicateRecordException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                    "code", "1004",
                    "message", "Action has been done previously by this user",
                    "note","Bạn đã block người này rồi "
            ));
        }
    }


    @PostMapping("/blockCommentsRequest/{userBId}")
    public ResponseEntity<?> createBlockCommentsRequest( @PathVariable int userBId,Principal principal) {
        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userAId =userDTO.getId();

try{
    blockService.createBlockCommentsRequest(userAId,userBId);
    return ResponseEntity.ok("Block comments successfully");
}
catch (BadRequestException e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "code", "1004",
            "message", "Parameter value is invalid",
            "note","Không thể block bản thân "
    ));
}
catch (DuplicateRecordException e){
    return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
            "code", "1004",
            "message", "Action has been done previously by this user",
            "note","Bạn đã block người này rồi "
    ));
}
    }




    @DeleteMapping("/block/{id}")
    public ResponseEntity<?> deleteBlockRequest(@PathVariable int id) {
        blockService.deleteBlockRequest(id);
        return ResponseEntity.ok("Deleted block");
    }
}
