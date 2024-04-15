package com.api.bai5.repository;

import com.api.bai5.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RolesEntity, String> {
}
