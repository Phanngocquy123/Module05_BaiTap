package com.ra.bt_tonghop.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "store_manager", catalog = "")
public class ProductsEntity {
    private String productId;
    private String productName;
    private String manufacturer;
    private Timestamp created;
    private short batch;
    private int quantity;
    private Boolean productStatus;

    @Id
    @Column(name = "Product_Id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "Product_Name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "Manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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
    @Column(name = "Batch")
    public short getBatch() {
        return batch;
    }

    public void setBatch(short batch) {
        this.batch = batch;
    }

    @Basic
    @Column(name = "Quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "Product_Status")
    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return batch == that.batch && quantity == that.quantity && Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(created, that.created) && Objects.equals(productStatus, that.productStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, manufacturer, created, batch, quantity, productStatus);
    }
}
