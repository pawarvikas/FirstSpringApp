package com.example.demoproductmainclass.service;

import com.example.demoproductmainclass.model.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
    Product createProduct(Product product);
}
