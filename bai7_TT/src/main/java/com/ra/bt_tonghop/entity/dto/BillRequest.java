package com.ra.bt_tonghop.entity.dto;


import com.ra.bt_tonghop.entity.EmployeesEntity;
import com.ra.bt_tonghop.entity.ProductsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor // constructor không tham số
@AllArgsConstructor  // đầy đủ tham số
@Setter
@Getter
public class BillRequest {
    private String billCode;
    private boolean billType;
    private short billStatus;
    private EmployeesEntity employeesByEmpIdCreated;
    private EmployeesEntity employeesByEmpIdAuth;

    private int quantity;
    private double price;
    private ProductsEntity productsByProductId;
}
