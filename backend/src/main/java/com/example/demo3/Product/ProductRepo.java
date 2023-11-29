package com.example.demo3.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query("SELECT u FROM Product u WHERE u.id = :id")
    Optional<Product> findById(long id);

    List<Product> findByUid(long uid);

    List<Product> findByBuyerId(long buyerId);
}
