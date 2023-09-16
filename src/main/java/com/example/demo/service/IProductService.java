package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.request.ProductAddRequest;
import com.example.demo.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product add(ProductAddRequest o);

    Boolean delete(Long id);

    Product update(Long id, ProductUpdateRequest o);

    List<Product> getAll();

    List<Product> get(String productName, Double sellPrice, Long categoryId, Long statusId, Long brandId);
}
