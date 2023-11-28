package com.example.demo3.Product;

import com.example.demo3.User.BBuser;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private BBuser bbuser;

    public Product() {
    }

    public Product(long id,long uid,  String name, String description, LocalDateTime createdAt) {
        this.uid = uid;
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }


    public Product( long uid, String name, String description, LocalDateTime createdAt) {
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }
    public void setbbuser(BBuser bbuser) {
        this.bbuser = bbuser;
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
}
