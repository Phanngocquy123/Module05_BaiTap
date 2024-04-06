package com.crud.bai3.service.impl;

import com.crud.bai3.exception.NotFoundEntityException;
import com.crud.bai3.model.dto.ProductRequest;
import com.crud.bai3.model.entity.Product;
import com.crud.bai3.repository.IProductRepository;
import com.crud.bai3.service.IProductService;
import com.crud.bai3.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor // tao constructor bat buoc cho ca truong duoc danh dau
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    private final UploadService uploadService;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(ProductRequest productRequest) {
        // kiem tra xem nguoi dung co gui file ko
        Product newProduct = new Product();
        if (productRequest.getFile().getSize()>0){
            // co file gui len
            String url = uploadService.uploadFileToServer(productRequest.getFile());
            newProduct.setImageUrl(url);
        }
        newProduct.setProductName(productRequest.getProductName());
        newProduct.setPrice(productRequest.getPrice());
        newProduct.setStock(productRequest.getStock());
        newProduct.setCreatedDate(new Date());
        newProduct.setDescription(productRequest.getDescription());
        newProduct.setStatus(true);

        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Product productRequest, MultipartFile imageUpdate) throws NotFoundEntityException {
        Product old = findById(productRequest.getProductId());
        if (imageUpdate.getSize()>0){
            String url = uploadService.uploadFileToServer(imageUpdate);
            old.setImageUrl(url);
        }
        old.setProductName(productRequest.getProductName());
        old.setPrice(productRequest.getPrice());
        old.setStock(productRequest.getStock());
        old.setDescription(productRequest.getDescription());
        old.setStatus(productRequest.getStatus());
        return productRepository.save(old);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) throws NotFoundEntityException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundEntityException("ko tim thay san pham"));
    }
}