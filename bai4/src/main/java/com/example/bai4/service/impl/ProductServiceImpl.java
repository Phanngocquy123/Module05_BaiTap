package com.example.bai4.service.impl;

import com.example.bai4.model.ProductRequest;
import com.example.bai4.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductRequest add(ProductRequest productRequest) {
        productRequest.setId(UUID.randomUUID().toString());
        return productRequest;
    }
}
