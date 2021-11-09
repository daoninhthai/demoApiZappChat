package com.example.zalo.model.mapper;

import com.example.zalo.entity.Block;
import com.example.zalo.entity.Friend;
import com.example.zalo.model.dto.BlockDTO;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.request.CreateBlockRequest;
import com.example.zalo.model.request.CreateFriendRequest;
import com.example.zalo.model.request.UpdateBlockRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BlockMapper {
    public static BlockDTO toBlockDTO(Block block) {
        BlockDTO tmp = new BlockDTO();
        tmp.setId(block.getId());
        tmp.setUserA(block.getUserA().getId());
        tmp.setUserB(block.getUserB().getId());
        tmp.setCreated(block.getCreated());
        tmp.setState(block.getState());
        return tmp;
    }


    public static Block toBlockChat(CreateBlockRequest request ) {
        Block block = new Block();
        block.setState("chat");
        LocalDate now = LocalDate.now();
        block.setCreated(now);
        return block;
    }

    public static Block toBlockDiary(CreateBlockRequest request ) {
        Block block = new Block();
        block.setState("diary");
        LocalDate now = LocalDate.now();
        block.setCreated(now);
        return block;
    }

    public static Block toBlock(UpdateBlockRequest request ) {

        return new Block();
    }
}
