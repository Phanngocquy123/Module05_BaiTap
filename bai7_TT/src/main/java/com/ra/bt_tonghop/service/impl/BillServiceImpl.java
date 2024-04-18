package com.ra.bt_tonghop.service.impl;

import com.ra.bt_tonghop.entity.BillDetailsEntity;
import com.ra.bt_tonghop.entity.BillsEntity;
import com.ra.bt_tonghop.entity.dto.BillCreationResult;
import com.ra.bt_tonghop.entity.dto.BillRequest;
import com.ra.bt_tonghop.exception.BaseException;
import com.ra.bt_tonghop.exception.ErrorMessageLoader;
import com.ra.bt_tonghop.repository.BillDetailRepository;
import com.ra.bt_tonghop.repository.BillRepository;
import com.ra.bt_tonghop.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // tạo contructor
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;
    private final BillDetailRepository billDetailRepository;
    private final ErrorMessageLoader errorMessageLoader;

    @Override
    public List<BillsEntity> findAll() {
        return billRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BillCreationResult addBill(BillRequest billRequest) throws Exception {
        BillsEntity newBill = new BillsEntity();
        newBill.setBillCode(billRequest.getBillCode());
        newBill.setBillType(billRequest.isBillType());
        newBill.setCreated(new Timestamp(System.currentTimeMillis()));
        newBill.setAuthDate(new Timestamp(System.currentTimeMillis()));
        newBill.setBillStatus(billRequest.getBillStatus());
        newBill.setEmployeesByEmpIdCreated(billRequest.getEmployeesByEmpIdCreated());
        newBill.setEmployeesByEmpIdAuth(billRequest.getEmployeesByEmpIdAuth());
        BillsEntity savedBill = billRepository.save(newBill);


        BillDetailsEntity newBillDetail = new BillDetailsEntity();
        newBillDetail.setQuantity(billRequest.getQuantity());
        newBillDetail.setPrice(billRequest.getPrice());
        newBillDetail.setProductsByProductId(billRequest.getProductsByProductId());
        newBillDetail.setBillsByBillId(savedBill);
        BillDetailsEntity savedBillDetail = billDetailRepository.save(newBillDetail);

        if (savedBill == null || savedBillDetail == null) {
            String errorMessage = errorMessageLoader.getMessage("RA-00-502");
            throw new BaseException(errorMessage);
        }

        return new BillCreationResult(savedBill, savedBillDetail);
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
