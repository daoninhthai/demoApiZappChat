package com.example.zalo.repository;

import java.util.List;
import java.util.Optional;


import com.example.zalo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  List<User> findByStatus(String status);

  User findByUsername(String username);

  @Transactional
  @Modifying
  @Query(value = "UPDATE user SET password = ?1  WHERE username = ?2", nativeQuery = true)
  void updatePassword(String password, String username);


  //used to filter user with type: Admin or user
  List<User> findByAuthority_authorityAndStatus(String authority, String status);

  @Query(value = "SELECT COUNT(*) FROM user u WHERE u.username LIKE :username% ", nativeQuery = true)
  Integer countByDuplicateFullName(String username);
  
  //used to search user by fullName or staffCode
  @Query(value = "SELECT * FROM user WHERE (CONCAT(first_name, \" \", last_name) LIKE :fullName "
  		+ "OR id = :id) AND status = 'enabled'", nativeQuery = true)
  List<User> findUserByFullNameOrId(String fullName, String id);
}
