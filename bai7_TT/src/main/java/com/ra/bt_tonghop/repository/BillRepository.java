package com.ra.bt_tonghop.repository;

import com.ra.bt_tonghop.entity.BillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<BillsEntity, Long> {
}
