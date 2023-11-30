package com.example.demo3.Categories;

import jakarta.persistence.*;

@Entity
@Table(name = "cat_table")
public class Categories {
    @Id
    @SequenceGenerator(
            name = "cat_sequence",
            sequenceName = "cat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cat_sequence"
    )
    private long catid;
    
}
