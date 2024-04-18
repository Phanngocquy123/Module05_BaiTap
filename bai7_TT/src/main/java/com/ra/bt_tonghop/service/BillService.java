package com.ra.bt_tonghop.service;

import com.ra.bt_tonghop.entity.BillsEntity;
import com.ra.bt_tonghop.entity.dto.BillCreationResult;
import com.ra.bt_tonghop.entity.dto.BillRequest;

import java.util.List;

public interface BillService {
    List<BillsEntity> findAll();
    BillCreationResult addBill(BillRequest billRequest) throws Exception;
    BillsEntity approveBill(long id);
}
