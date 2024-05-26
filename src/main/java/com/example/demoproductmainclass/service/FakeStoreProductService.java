package com.example.demoproductmainclass.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demoproductmainclass.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getSingleProduct(Long productId) {
        System.out.println("We are at getSingleProduct");
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        System.out.println("We are at getAllProducts");

        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        System.out.println("we are at createProduct");
        return null;
    }
}
