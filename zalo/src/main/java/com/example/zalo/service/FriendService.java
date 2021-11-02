package com.example.zalo.service;

import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.request.CreateFriendRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendService {
    List<FriendDTO> getAllFriend(int userId);

    List<FriendDTO> getAllFriendRequest(int userId);

    FriendDTO createFriendRequest(CreateFriendRequest request, int userBId);

    void acceptFriendRequest( int id);

    void deleteFriendRequest(int id);// đúng trong cả trường hợp gửi lời mời kết bạn và
    // trường hợp từ chối lời mời kết bạn
}
