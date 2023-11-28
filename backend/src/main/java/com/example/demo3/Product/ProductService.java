package com.example.demo3.Product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    //getting product
    public List<Product> getProducts(){
        return productRepo.findAll();
    }
    // adding new product
    public void addNewProduct(Product product){
        productRepo.save(product);
    }


}
