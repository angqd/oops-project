package com.example.demo3.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query("SELECT u FROM Product u WHERE u.id = :id")
    Optional<Product> findById(long id);

    List<Product> findByUid(long uid);

    List<Product> findByBuyerId(long buyerId);

    // ProductRepository.java
    // ProductRepository.java
    // ProductRepository.java
    // ProductRepository.java
    @Query(value = "SELECT * FROM product_table p WHERE SIMILARITY(CAST(p.name AS text), CAST(:searchQuery AS text)) > 0.1 AND p.uid != :uid ORDER BY SIMILARITY(CAST(p.name AS text), CAST(:searchQuery AS text)) DESC LIMIT 10", nativeQuery = true)
    List<Product> fuzzySearchProducts(@Param("uid") Long uid, @Param("searchQuery") String searchQuery);

    // Additional query to get all products with uid not equal to the provided uid
    List<Product> findByUidNot(Long uid);


}
