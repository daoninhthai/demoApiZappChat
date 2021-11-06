package com.example.zalo.model.mapper;

import com.example.zalo.entity.Friend;
import com.example.zalo.entity.User;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateFriendRequest;
import com.example.zalo.service.UserService;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class FriendMapper {

    private static UserService userService;



    public static FriendDTO toFriendDTO(Friend friend) {
        FriendDTO tmp = new FriendDTO();
        tmp.setId(friend.getId());
        tmp.setUserA(friend.getUserA().getId());
        tmp.setUserB(friend.getUserB().getId());
        tmp.setCreated(friend.getCreated());
        tmp.setState(friend.getState());
        return tmp;
    }





    public static Friend toFriend(CreateFriendRequest request ) {
        Friend friend = new Friend();

        friend.setState("waiting");
        friend.setCreated(request.getCreated());
        return friend;
    }

    public static Friend toFriend( int userBId) {
        Friend friend = new Friend();
        return friend;
    }
}
