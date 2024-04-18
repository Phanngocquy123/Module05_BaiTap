package com.ra.bt_tonghop.api;

import com.ra.bt_tonghop.entity.BillsEntity;
import com.ra.bt_tonghop.entity.dto.BillCreationResult;
import com.ra.bt_tonghop.entity.dto.BillRequest;
import com.ra.bt_tonghop.exception.BaseException;
import com.ra.bt_tonghop.exception.ErrorMessageLoader;
import com.ra.bt_tonghop.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApi {
    private final BillService billService;
    private final ErrorMessageLoader errorMessageLoader;

    @GetMapping("/orders/show-all")
    public ResponseEntity<List<BillsEntity>> showAllOrders() {
        List<BillsEntity> allBills = billService.findAll();
        if (allBills.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allBills);
    }
    @PostMapping("/orders/approve")
    public ResponseEntity<BillsEntity> doApprove(@RequestBody BillsEntity billsEntity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getAuthorities().stream().anyMatch(x -> x.getAuthority().equals("ROLE_APPROVE"))) {
            long billId = billsEntity.getBillId();

            BillsEntity approvedBill = billService.approveBill(billId);
            if (approvedBill != null) {
                return ResponseEntity.ok(approvedBill);
            } else {
                String errorMessage = errorMessageLoader.getMessage("RA-00-501"); // không tìm thấy id
                throw new BaseException(errorMessage);
            }
        } else {
            String errorMessage = errorMessageLoader.getMessage("RA-00-500");
            throw new BaseException(errorMessage);
        }
    }

    @PostMapping("/orders/create")
    @PreAuthorize("hasRole('CREATE')")
    public BillCreationResult doCreate(@RequestBody BillRequest billRequest) throws Exception {
        return billService.addBill(billRequest);
    }
}