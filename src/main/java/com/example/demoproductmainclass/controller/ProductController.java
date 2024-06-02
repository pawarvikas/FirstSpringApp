package com.example.demoproductmainclass.controller;

import com.example.demoproductmainclass.model.Product;
import com.example.demoproductmainclass.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        Product postRequestResponse = productService.createProduct(product);
        return postRequestResponse;
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        Product currentproduct = productService.getSingleProduct(productId);
        return currentproduct;
    }

    @GetMapping("/products")
    public void getAllProducts(){
        productService.getAllProducts();
    }

        // Need to add for update and delete

}
