package com.example.healthfood.controller;

import com.example.healthfood.domain.model.Food;
import com.example.healthfood.application.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = foodService.getAllFood();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        Food food = foodService.getFoodById(id);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Food>> getFoodByType(@PathVariable String type) {
        List<Food> foods = foodService.getFoodByType(type);
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Food> saveFood(@RequestBody Food food) {
        Food savedFood = foodService.addFood(food);
        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
