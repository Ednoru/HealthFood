package com.example.healthfood.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class FoodDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Positive
    private double price;

    @PositiveOrZero
    private int calories;

    @PositiveOrZero
    private double proteins;

    @PositiveOrZero
    private double carbohydrates;

    @PositiveOrZero
    private double fats;
}
