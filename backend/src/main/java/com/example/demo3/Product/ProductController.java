package com.example.demo3.Product;

import com.example.demo3.Product.RequestClasses.ProductAddRequest;
import com.example.demo3.Product.RequestClasses.ProductEditRequest;
import com.example.demo3.Product.RequestClasses.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
                request.getCurrentBid(),
                request.gettImage()
        );
    }
    //SELLER DASHBOARD
    //find products by uid SELLER DASHBOARD
    @PutMapping("/sellerDash")
    public List<Product> getAllProductsByUid(@RequestBody Map<String, Long> requestBody){
        long uid = requestBody.get("uid");
        return productService.getProductsByUid(uid);
    }
    //BUYER DASHBOARD
    // NOTE : As of now to edit the buyerId u need to use the /edit Post request
    // by default its null

    @PutMapping ("/buyerDash")
    public List<Product> getAllProductsByBuyerId(@RequestBody Map<String,Long> requestBody){
        long buyerId = requestBody.get("uid");
        return productService.getProductsByBuyerId(buyerId);
    }
    // edit bids (PLACE BID )
    @PostMapping(path = "/edit")
    public void editBids(@RequestBody ProductEditRequest request) {
        productService.editbids(request.getId(), request.getCurrentBid(), request.getBuyerId());
    }



    // ProductController.java
    @PutMapping("/search")
    public List<Product> fuzzySearchProducts(@RequestBody SearchRequest searchRequest) {
        return productService.fuzzySearchProducts(searchRequest.getUid(), searchRequest.getSearchQuery());
    }
    //Mark bid as frozen
    @PostMapping(path = "/freeze")
    public void markAsFrozen(@RequestBody Map<String,Long> request){
        long pid = request.get("pid");
        productService.markFrozen(pid);
    }

    //Mark Product as Sold
    @PostMapping(path = "/sold")
    public void markAsSold(@RequestBody Map<String,Long> request){
        long pid = request.get("pid");
        productService.markSold(pid);
    }


}
