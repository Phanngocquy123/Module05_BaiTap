package com.example.bai2.service;

import com.example.bai2.entity.ProductEntity;


import java.util.List;

public interface ProductService {
    List<ProductEntity> findByKey(String key, Integer batch);
    List<ProductEntity> findByExample(ProductEntity productEntity);
}
