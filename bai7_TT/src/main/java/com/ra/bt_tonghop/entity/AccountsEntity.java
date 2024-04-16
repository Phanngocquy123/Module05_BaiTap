package com.ra.bt_tonghop.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "accounts", schema = "store_manager", catalog = "")
public class AccountsEntity {
    private int accId;
    private String userName;
    private String password;
    private Boolean permission;
    private String empId;
    private Boolean accStatus;

    @Id
    @Column(name = "Acc_Id")
    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    @Basic
    @Column(name = "User_Name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Permission")
    public Boolean getPermission() {
        return permission;
    }

    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    @Basic
    @Column(name = "Emp_Id")
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "Acc_Status")
    public Boolean getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(Boolean accStatus) {
        this.accStatus = accStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountsEntity that = (AccountsEntity) o;
        return accId == that.accId && Objects.equals(userName, that.userName) && Objects.equals(password, that.password) && Objects.equals(permission, that.permission) && Objects.equals(empId, that.empId) && Objects.equals(accStatus, that.accStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accId, userName, password, permission, empId, accStatus);
    }
}
