package com.example.bai4.controller;

import com.example.bai4.model.ProductRequest;
import com.example.bai4.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ProductRequest post(@RequestBody ProductRequest productRequest){
        ProductRequest result =  productService.add(productRequest);
        return result;
    }
}
