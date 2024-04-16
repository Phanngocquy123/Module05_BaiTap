package com.ra.bt_tonghop.service;

import com.ra.bt_tonghop.entity.BillsEntity;

import java.util.List;

public interface BillService {
    List<BillsEntity> findAll();
    BillsEntity addBill(BillsEntity entity);
    BillsEntity approveBill(long id);
}
