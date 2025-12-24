package com.example.demo.controller;

import com.example.demo.entity.SpendCategory;
import com.example.demo.service.SpendCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spend-categories")
public class SpendCategoryController {

    private final SpendCategoryService spendCategoryService;

    public SpendCategoryController(SpendCategoryService spendCategoryService) {
        this.spendCategoryService = spendCategoryService;
    }

    @PostMapping
    public ResponseEntity<SpendCategory> createCategory(@RequestBody SpendCategory category) {
        return ResponseEntity.ok(spendCategoryService.saveCategory(category));
    }

    @GetMapping
    public ResponseEntity<List<SpendCategory>> getAllCategories() {
        return ResponseEntity.ok(spendCategoryService.getAllCategories());
    }
}
