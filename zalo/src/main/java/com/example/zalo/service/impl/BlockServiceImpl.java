package com.example.zalo.service.impl;

import com.example.zalo.entity.Block;
import com.example.zalo.entity.Friend;
import com.example.zalo.entity.User;
import com.example.zalo.exception.DuplicateRecordException;
import com.example.zalo.exception.InternalServerException;
import com.example.zalo.exception.NotFoundException;
import com.example.zalo.model.dto.BlockDTO;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.mapper.BlockMapper;
import com.example.zalo.model.mapper.FriendMapper;
import com.example.zalo.model.request.CreateBlockRequest;
import com.example.zalo.repository.BlockRepository;
import com.example.zalo.service.BlockService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BlockServiceImpl implements BlockService {
    private final BlockRepository blockRepository;

    public BlockServiceImpl(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Override
    public List<BlockDTO> getAllBlockChat(int userId) {
        List<Block> blocks = blockRepository.getAllBlockChat(userId);
        List<BlockDTO> result = new ArrayList<>();
        for (Block block:blocks){
            result.add(BlockMapper.toBlockDTO(block));
        }
        return result;
    }

    @Override
    public List<BlockDTO> getAllBlockDiary(int userId) {
        List<Block> blocks = blockRepository.getAllBlockDiary(userId);
        List<BlockDTO> result = new ArrayList<>();
        for (Block block:blocks){
            result.add(BlockMapper.toBlockDTO(block));
        }
        return result;
    }

    @Override
    public void createBlockChatRequest(CreateBlockRequest request, int userAId, int userBId) {
        if(userAId == userBId){
            throw new DuplicateRecordException("You cannot send friend requests to yourself");
        }

        List<Block> blocks= blockRepository.findAll();
        for(Block b:blocks){
            if(b.getUserA().getId()==userAId && b.getUserB().getId()==userBId && b.getState().equals("chat") ){
                    throw new DuplicateRecordException("you have blocked this person's messages before");
            }
        }
        Block block = new Block();
        User userA = new User();
        User userB = new User();

        userA.setId(userAId);
        userB.setId(userBId);

        block.setUserA(userA);
        block.setUserB(userB);

        block= BlockMapper.toBlockChat(request);
        block.setUserA(userA);
        block.setUserB(userB);

        try {
            blockRepository.save(block);
        } catch (Exception ex) {
            throw new InternalServerException("Can't block this person");
        }
    }

    @Override
    public void createBlockDiaryRequest(CreateBlockRequest request, int userAId, int userBId) {
        if(userAId == userBId){
            throw new DuplicateRecordException("You cannot send friend requests to yourself");
        }

        List<Block> blocks= blockRepository.findAll();
        for(Block b:blocks){
            if(b.getUserA().getId()==userAId && b.getUserB().getId()==userBId && b.getState().equals("diary") ){
                throw new DuplicateRecordException("you blocked this person before");
            }
        }
        Block block = new Block();
        User userA = new User();
        User userB = new User();

        userA.setId(userAId);
        userB.setId(userBId);

        block.setUserA(userA);
        block.setUserB(userB);

        block= BlockMapper.toBlockDiary(request);
        block.setUserA(userA);
        block.setUserB(userB);

        try {
            blockRepository.save(block);
        } catch (Exception ex) {
            throw new InternalServerException("Can't block this person");
        }
    }

    @Override
    public void deleteBlockRequest(int id) {
        Optional<Block> block = blockRepository.findById(id);
        if (block.isEmpty()) {
            throw new NotFoundException("No block found");
        }

        try {
            blockRepository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalServerException("Can't delete this block");
        }

    }
}
