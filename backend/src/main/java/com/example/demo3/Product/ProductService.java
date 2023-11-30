package com.example.demo3.Product;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.demo3.Product.ProductChecker.setFreezeBidForTimeUp;

@Service
public class ProductService {

    private final ProductRepo productRepo;


    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    //getting all products
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

    public void addProduct(String name, String description, long uid,
                           LocalDateTime createdAt, LocalDateTime endsAt,
                           double currentBid, String tImage) {
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setUid(uid);
        newProduct.setCreatedAt(createdAt);
        newProduct.setEndsAt(endsAt);
        newProduct.setCurrentBid(currentBid);
        newProduct.settImage(tImage);
        productRepo.save(newProduct);
    }

    public List<Product> getProductsByUid(long uid) {
        List<Product> products =  productRepo.findByUid(uid);
        setFreezeBidForTimeUp(products);
        return products;
    }

    public List<Product> getProductsByBuyerId(long buyerId) {
        List<Product> products = productRepo.findByBuyerId(buyerId);
        setFreezeBidForTimeUp(products);
        return products;
    }


    // ProductService.java
    public List<Product> fuzzySearchProducts(Long uid, String searchQuery) {
        if (StringUtils.isEmpty(searchQuery)) {
            // If the search query is empty, return all products with uid not equal to the provided uid
            List<Product> products = productRepo.findByUidNot(uid);
            setFreezeBidForTimeUp(products);
            return products;
        } else {
            List<Product> products = productRepo.fuzzySearchProducts(uid, searchQuery);
            setFreezeBidForTimeUp(products);
            return products;
            // Perform fuzzy search with uid not equal to the provided uid
        }
    }


    public void markFrozen(long pid) {
        Product product = productRepo.findById(pid).orElse(null);

        if (product != null) {
            product.setFreezeBid(true);
            productRepo.save(product);
        }
    }

    public void markSold(long pid) {
        Product product = productRepo.findById(pid).orElse(null);

        if (product != null) {
            product.setSold(true);
            productRepo.save(product);
        }
    }
}
