package com.ra.bt_tonghop.entity.dto;

import com.ra.bt_tonghop.entity.BillDetailsEntity;
import com.ra.bt_tonghop.entity.BillsEntity;



public class BillCreationResult {
    private BillsEntity savedBill;
    private BillDetailsEntity savedBillDetail;

    public BillCreationResult(BillsEntity savedBill, BillDetailsEntity savedBillDetail) {
        this.savedBill = savedBill;
        this.savedBillDetail = savedBillDetail;
    }

    public BillsEntity getSavedBill() {
        return savedBill;
    }

    public void setSavedBill(BillsEntity savedBill) {
        this.savedBill = savedBill;
    }

    public BillDetailsEntity getSavedBillDetail() {
        return savedBillDetail;
    }

    public void setSavedBillDetail(BillDetailsEntity savedBillDetail) {
        this.savedBillDetail = savedBillDetail;
    }
}