package com.ra.bt_tonghop.repository;

import com.ra.bt_tonghop.entity.BillDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetailsEntity, Long> {
}
