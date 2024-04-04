package com.example.bai2.model;

import com.example.bai2.entity.ProductEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class ProductSpecification implements Specification<ProductEntity> {
    private String value;
    private String fieldName;
    private String operation; // > < >= <=


    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.like(root.get("productId"), value));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
