package com.example.bai2.controller;

import com.example.bai2.entity.ProductEntity;
import com.example.bai2.exception.BaseException;
import com.example.bai2.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductEntity> get(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "batch", required = false) Integer batch) {
//        LOGGER.info("ProductsController get with request key={}, batch={}", key, batch);
//        if (key == null)
//            throw new BaseException("RA-00-01");
        return productService.findByKey("pro", 6);
    }
    @GetMapping("/example")
    public List<ProductEntity> example() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("pro");
        productEntity.setBatch((short) 3);
        return productService.findByExample(productEntity);
    }
}
