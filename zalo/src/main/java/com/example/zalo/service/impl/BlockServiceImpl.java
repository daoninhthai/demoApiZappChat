package com.example.zalo.service.impl;

import com.example.zalo.model.dto.BlockDTO;
import com.example.zalo.model.request.CreateBlockRequest;
import com.example.zalo.service.BlockService;

import java.util.List;

public class BlockServiceImpl implements BlockService {
    @Override
    public List<BlockDTO> getAllBlockChat(int userId) {
        return null;
    }

    @Override
    public List<BlockDTO> getAllBlockDiary(int userId) {
        return null;
    }

    @Override
    public void createBlockRequest(CreateBlockRequest request, int userAId, int userBId) {

    }

    @Override
    public void deleteBlockRequest(int id) {

    }
}
