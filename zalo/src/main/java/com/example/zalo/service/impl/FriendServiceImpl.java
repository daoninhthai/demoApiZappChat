package com.example.zalo.service.impl;

import com.example.zalo.entity.Friend;
import com.example.zalo.entity.Post;
import com.example.zalo.entity.User;
import com.example.zalo.exception.InternalServerException;
import com.example.zalo.exception.NotFoundException;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.mapper.FriendMapper;
import com.example.zalo.model.request.CreateFriendRequest;
import com.example.zalo.repository.FriendRepository;
import com.example.zalo.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class FriendServiceImpl implements FriendService {
    private final FriendRepository friendRepository;
    @Autowired
    public FriendServiceImpl(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public List<FriendDTO> getAllFriend(int userId) {
        List<Friend> friends =friendRepository.getAllFriend(userId);
        List<FriendDTO> result = new ArrayList<>();
        for (Friend friend:friends){
            result.add(FriendMapper.toFriendDTO(friend));
        }
        return result;
    }

    @Override
    public List<FriendDTO> getAllFriendRequest(int userId) {

        List<Friend> friends =friendRepository.getAllRequestFriend(userId);
        List<FriendDTO> result = new ArrayList<>();
        for (Friend friend:friends){
            result.add(FriendMapper.toFriendDTO(friend));
        }
        return result;
    }

    @Override
    public FriendDTO createFriendRequest(CreateFriendRequest request,int userAId,int userBId) {
        Friend friend = new Friend();
        User userA = new User();
        User userB = new User();

        userA.setId(userAId);
        userB.setId(userBId);

        friend.setUserA(userA);
        friend.setUserB(userB);

        friend= FriendMapper.toFriend(request);
        friend.setUserA(userA);
        friend.setUserB(userB);
        friendRepository.save(friend);

        return FriendMapper.toFriendDTO(friend);
    }

    @Override
    public void acceptFriendRequest( int id) {
        Optional<Friend> friend = friendRepository.findById(id);
        if (friend.isEmpty()) {
            throw new NotFoundException("No friend request found");
        }
        String state ="accepted";

        try {

            friendRepository.acceptFriendRequest(id,state);
        } catch (Exception ex) {
            throw new InternalServerException("Can't accept request");
        }


    }

    @Override
    public void deleteFriendRequest(int id) {
        Optional<Friend> friend = friendRepository.findById(id);
        if (friend.isEmpty()) {
            throw new NotFoundException("No friend request found");
        }

        try {
            friendRepository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalServerException("Can't delete request");
        }
    }
}
