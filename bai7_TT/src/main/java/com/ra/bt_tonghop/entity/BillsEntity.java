package com.ra.bt_tonghop.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "bills", schema = "store_manager", catalog = "")
public class BillsEntity {
    private long billId;
    private String billCode;
    private boolean billType;
    private Timestamp created;
    private Timestamp authDate;
    private short billStatus;
    private EmployeesEntity employeesByEmpIdCreated;
    private EmployeesEntity employeesByEmpIdAuth;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bill_Id")
    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    @Basic
    @Column(name = "Bill_Code")
    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    @Basic
    @Column(name = "Bill_Type")
    public boolean isBillType() {
        return billType;
    }

    public void setBillType(boolean billType) {
        this.billType = billType;
    }

    @Basic
    @Column(name = "Created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "Auth_Date")
    public Timestamp getAuthDate() {
        return authDate;
    }

    public void setAuthDate(Timestamp authDate) {
        this.authDate = authDate;
    }

    @Basic
    @Column(name = "Bill_Status")
    public short getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(short billStatus) {
        this.billStatus = billStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillsEntity that = (BillsEntity) o;
        return billId == that.billId && billType == that.billType && billStatus == that.billStatus && Objects.equals(billCode, that.billCode) && Objects.equals(created, that.created) && Objects.equals(authDate, that.authDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId, billCode, billType, created, authDate, billStatus);
    }

    @ManyToOne
    @JoinColumn(name = "Emp_Id_Created", referencedColumnName = "Emp_Id", nullable = false)
    public EmployeesEntity getEmployeesByEmpIdCreated() {
        return employeesByEmpIdCreated;
    }

    public void setEmployeesByEmpIdCreated(EmployeesEntity employeesByEmpIdCreated) {
        this.employeesByEmpIdCreated = employeesByEmpIdCreated;
    }

    @ManyToOne
    @JoinColumn(name = "Emp_Id_Auth", referencedColumnName = "Emp_Id", nullable = false)
    public EmployeesEntity getEmployeesByEmpIdAuth() {
        return employeesByEmpIdAuth;
    }

    public void setEmployeesByEmpIdAuth(EmployeesEntity employeesByEmpIdAuth) {
        this.employeesByEmpIdAuth = employeesByEmpIdAuth;
    }
}
