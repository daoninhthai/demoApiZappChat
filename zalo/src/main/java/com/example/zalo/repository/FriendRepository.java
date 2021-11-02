package com.example.zalo.repository;

import com.example.zalo.entity.Authority;
import com.example.zalo.entity.Comment;
import com.example.zalo.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FriendRepository  extends JpaRepository<Friend, Integer> {
    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM friend  WHERE userA = ?1 , state like  '%accepted%' ", nativeQuery = true)
    public List<Friend> getAllFriend(int userId);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM friend  WHERE userB= ?1 , state like  '%waiting%' ", nativeQuery = true)
    public List<Friend> getAllRequestFriend(int userId);


    @Transactional
    @Modifying
    @Query(value = "UPDATE friend SET state = ?2 WHERE id = ?1", nativeQuery = true)
    void acceptFriendRequest(int id, String state);
}
