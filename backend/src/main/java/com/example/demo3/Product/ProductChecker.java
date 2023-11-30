package com.example.demo3.Product;

import java.util.List;

public class ProductChecker {
    public static void setFreezeBidForTimeUp(List<Product> products) {
        for (Product product : products) {
            if (product.isTimeUp()) {
                product.setFreezeBid(true);
            }
        }
    }
}
