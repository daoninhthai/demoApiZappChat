package com.example.zalo.model.mapper;

import com.example.zalo.entity.Friend;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.request.CreateFriendRequest;
import org.springframework.stereotype.Component;

@Component
public class FriendMapper {


    public static FriendDTO toFriendDTO(Friend friend) {
        FriendDTO tmp = new FriendDTO();
        tmp.setId(friend.getId());
        tmp.setUserA(friend.getId());
        tmp.setUserB(friend.getId());
        tmp.setCreated(friend.getCreated());
        tmp.setState(friend.getState());
        return tmp;
    }


    public static Friend toFriend(CreateFriendRequest request, int userBId) {
        Friend friend = new Friend();

        friend.setState(request.getState());
        friend.setCreated(request.getCreated());
        return friend;
    }

    public static Friend toFriend( int userBId) {
        Friend friend = new Friend();
        return friend;
    }
}
