package com.example.healthfood.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Food")
@Data
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int calories;

    @Column(nullable = false)
    private double proteins;

    @Column(nullable = false)
    private double carbohydrates;

    @Column(nullable = false)
    private double fats;

    @Column(nullable = false)
    private String image;
}





