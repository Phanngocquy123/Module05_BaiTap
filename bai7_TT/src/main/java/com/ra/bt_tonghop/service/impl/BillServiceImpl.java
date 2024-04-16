package com.ra.bt_tonghop.service.impl;

import com.ra.bt_tonghop.entity.BillsEntity;
import com.ra.bt_tonghop.repository.BillRepository;
import com.ra.bt_tonghop.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // tạo contructor

public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;

    @Override
    public List<BillsEntity> findAll() {
        return billRepository.findAll();
    }

    @Override
    public BillsEntity addBill(BillsEntity entity) {
        BillsEntity newBill = new BillsEntity();

        newBill.setBillCode(entity.getBillCode());
        newBill.setBillType(entity.isBillType());
        newBill.setCreated(entity.getCreated());
        newBill.setAuthDate(entity.getAuthDate());
        newBill.setBillStatus(entity.getBillStatus());
        newBill.setEmployeesByEmpIdCreated(entity.getEmployeesByEmpIdCreated());
        newBill.setEmployeesByEmpIdAuth(entity.getEmployeesByEmpIdAuth());

        return billRepository.save(newBill);
    }

    @Override
    public BillsEntity approveBill(long id) {
        Optional<BillsEntity> optionalBill = billRepository.findById(id);
        if (optionalBill.isPresent()) {
            BillsEntity bill = optionalBill.get();
            bill.setBillStatus((short) 1);
            return billRepository.save(bill);
        } else {

            return null;
        }
    }
}
