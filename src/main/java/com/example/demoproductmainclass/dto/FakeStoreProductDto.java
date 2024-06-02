package com.example.demoproductmainclass.dto;

import com.example.demoproductmainclass.model.Category;
import com.example.demoproductmainclass.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductDto
{
//    id:1,
//    title:'...',
//    price:'...',
//    category:'...',
//    description:'...',
//    image:'...




    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public Product toProduct(){
        Product p = new Product();
        p.setId(id);
        p.setTitle(title);
        p.setPrice(price);
        p.setDescription(description);
        p.setImageUrl(image);

        Category cat = new Category();
        cat.setTitle(category);
        p.setCategory(cat);
        return p;
}
}
