package com.api.bai5.repository;

import com.api.bai5.entity.UserRoleEntity;
import com.api.bai5.entity.UserRoleEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, UserRoleEntityPK> {
}