package com.crud.bai3.service;

import com.crud.bai3.exception.NotFoundEntityException;
import com.crud.bai3.model.dto.ProductRequest;
import com.crud.bai3.model.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product addProduct(ProductRequest productRequest);
    Product updateProduct(Product product, MultipartFile imageUpdate) throws NotFoundEntityException;
    void deleteById(Long id);
    Product findById(Long id) throws NotFoundEntityException;
}

