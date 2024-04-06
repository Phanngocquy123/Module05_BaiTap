package com.crud.bai3.repository;

import com.crud.bai3.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}