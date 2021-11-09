package com.example.zalo.repository;

import com.example.zalo.entity.Block;
import com.example.zalo.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {
    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM block  WHERE  user_a=?1  and state like '%chat%'  ", nativeQuery = true)
    public List<Block> getAllBlockChat(int userId);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM block  WHERE  user_a=?1  and state like '%diary%'  ", nativeQuery = true)
    public List<Block> getAllBlockDiary(int userId);

}
