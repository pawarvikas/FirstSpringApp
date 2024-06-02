package com.example.demoproductmainclass.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demoproductmainclass.dto.FakeStoreProductDto;
import com.example.demoproductmainclass.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        System.out.println("We are at getSingleProduct");
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/"+productId,FakeStoreProductDto.class);

        return fakeStoreProductDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        System.out.println("We are at getAllProducts");

        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        System.out.println("we are at createProduct");
//               id:31,
//                title:'...',
//                price:'...',
//                category:'...',
//                description:'...',
//                image:'...'
        FakeStoreProductDto fs = new FakeStoreProductDto();
        fs.setId(product.getId());
        fs.setTitle(product.getTitle());
        fs.setPrice(product.getPrice());
        fs.setCategory(product.getCategory().getTitle());
        fs.setDescription(product.getDescription());
        fs.setImage(product.getImageUrl());

        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products/",
                fs,
                FakeStoreProductDto.class
        );
        return response.toProduct();
    }
}
