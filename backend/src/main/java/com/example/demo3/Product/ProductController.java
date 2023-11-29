package com.example.demo3.Product;

import com.example.demo3.Product.RequestClasses.ProductAddRequest;
import com.example.demo3.Product.RequestClasses.ProductEditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/products")
public class ProductController {
    private final ProductService productService;
@Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    // ADD NEW PRODUCTS
    @PostMapping(path="/add")
    public void addProduct(@RequestBody ProductAddRequest request){
        productService.addProduct(
                request.getName(),
                request.getDescription(),
                request.getUid(),
                request.getCreatedAt(),
                request.getEndsAt(),
                request.getCurrentBid()
        );
    }
    // edit bids (PLACE BID )
    @PostMapping(path = "/edit")
    public void editBids(@RequestBody ProductEditRequest request) {
        productService.editbids(request.getId(), request.getCurrentBid(), request.getBuyerId());
    }


}
