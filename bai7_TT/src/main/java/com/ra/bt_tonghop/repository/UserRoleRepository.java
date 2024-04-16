package com.ra.bt_tonghop.repository;

import com.ra.bt_tonghop.entity.UserRoleEntity;
import com.ra.bt_tonghop.entity.UserRoleEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, UserRoleEntityPK> {
}