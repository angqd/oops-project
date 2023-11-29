package com.example.demo3.Product;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public void editbids(long id, double currentBid, long buyerId) {
        // Find the product by ID
        Optional<Product> optionalProduct = productRepo.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            // Set the new currentBid and buyerId values
            product.setCurrentBid(currentBid);
            product.setBuyerId(buyerId);

            // Save the updated product
            productRepo.save(product);
        } else {
            // Handle the case where the product with the given ID is not found
            throw new EntityNotFoundException("Product with ID " + id + " not found");
        }
    }

    public void addProduct( String name, String description, long uid,
                           LocalDateTime createdAt, LocalDateTime endsAt,
                           double currentBid) {
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setUid(uid);
        newProduct.setCreatedAt(createdAt);
        newProduct.setEndsAt(endsAt);
        newProduct.setCurrentBid(currentBid);
        productRepo.save(newProduct);
    }
}
