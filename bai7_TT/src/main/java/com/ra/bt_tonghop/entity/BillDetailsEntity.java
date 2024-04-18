package com.ra.bt_tonghop.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "bill_details", schema = "store_manager", catalog = "")
public class BillDetailsEntity {
    private long billDetailId;
    private int quantity;
    private double price;
    private BillsEntity billsByBillId;
    private ProductsEntity productsByProductId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bill_Detail_Id")
    public long getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(long billDetailId) {
        this.billDetailId = billDetailId;
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
    @Column(name = "Price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillDetailsEntity that = (BillDetailsEntity) o;
        return billDetailId == that.billDetailId && quantity == that.quantity && Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(billDetailId, quantity, price);
    }

    @ManyToOne
    @JoinColumn(name = "Bill_Id", referencedColumnName = "Bill_Id", nullable = false)
    public BillsEntity getBillsByBillId() {
        return billsByBillId;
    }

    public void setBillsByBillId(BillsEntity billsByBillId) {
        this.billsByBillId = billsByBillId;
    }

    @ManyToOne
    @JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id", nullable = false)
    public ProductsEntity getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(ProductsEntity productsByProductId) {
        this.productsByProductId = productsByProductId;
    }
}
