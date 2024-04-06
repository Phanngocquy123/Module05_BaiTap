package com.crud.bai3.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor // constructor 0 tham so
@AllArgsConstructor // day du tham so
@Setter
@Getter
@Entity // Chi dinh Lop anh xa voi 1 Table trong CSDL
//@Table(name = "")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tu dong sinh gia tri
    private Long productId;
    private String productName;
    private Double price;
    private Integer stock;
    private String description;
    private String imageUrl;
    private Date createdDate;
    private Boolean status;
}