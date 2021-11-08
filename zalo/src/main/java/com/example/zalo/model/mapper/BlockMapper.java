package com.example.zalo.model.mapper;

import com.example.zalo.entity.Block;
import com.example.zalo.entity.Friend;
import com.example.zalo.model.dto.BlockDTO;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.request.CreateBlockRequest;
import com.example.zalo.model.request.CreateFriendRequest;
import com.example.zalo.model.request.UpdateBlockRequest;

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


    public static Block toBlock(CreateBlockRequest request ) {
        Block block = new Block();
        block.setCreated(request.getCreated());
        return block;
    }

    public static Block toBlock(UpdateBlockRequest request ) {

        return new Block();
    }
}
