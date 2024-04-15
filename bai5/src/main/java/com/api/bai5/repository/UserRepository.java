package com.api.bai5.repository;

import com.api.bai5.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, String> {
    UsersEntity findByUsername(String username);
}