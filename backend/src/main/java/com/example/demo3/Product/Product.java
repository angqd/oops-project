package com.example.demo3.Product;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="product_table")
public class Product {



    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )

    private long id;

    private long uid;
    private String name;
    private String description;



    private double currentBid;
    private boolean freezeBid;
    private Long catId;
    private boolean Sold;


    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private LocalDateTime createdAt;
    private LocalDateTime endsAt;


    private long buyerId;

    public Product() {
    }

    public Product(long id, long uid, String name, String description, double currentBid, boolean freezeBid, Long catId, boolean sold,
                   LocalDateTime createdAt, LocalDateTime endsAt, Long buyerId) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.currentBid = currentBid;
        this.freezeBid = freezeBid;
        this.catId = catId;
        Sold = sold;
        this.createdAt = createdAt;
        this.endsAt = endsAt;
        this.buyerId = buyerId;
    }

    public Product(long uid, String name, String description, double currentBid, boolean freezeBid, Long catId, boolean sold, LocalDateTime createdAt,
                   LocalDateTime endsAt, Long buyerId) {
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.currentBid = currentBid;
        this.freezeBid = freezeBid;
        this.catId = catId;
        Sold = sold;
        this.createdAt = createdAt;
        this.endsAt = endsAt;
        this.buyerId = buyerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public boolean isFreezeBid() {
        return freezeBid;
    }

    public void setFreezeBid(boolean freezeBid) {
        this.freezeBid = freezeBid;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public boolean isSold() {
        return Sold;
    }

    public void setSold(boolean sold) {
        Sold = sold;
    }
    public LocalDateTime getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(LocalDateTime endsAt) {
        this.endsAt = endsAt;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

}
