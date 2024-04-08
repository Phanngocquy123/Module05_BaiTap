package com.example.bai4.model;

import lombok.Data;

@Data
public class ProductRequest {
    private String id;
    private String name;
    private float price;
    private boolean status;
}
