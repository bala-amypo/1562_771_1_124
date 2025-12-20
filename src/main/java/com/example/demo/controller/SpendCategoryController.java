package com.example.demo.controller;

import com.example.demo.entity.SpendCategory;
import com.example.demo.repository.SpendCategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spend-categories")
public class SpendCategoryController {

    private final SpendCategoryRepository repository;

    public SpendCategoryController(SpendCategoryRepository repository) {
        this.repository = repository;
    }

    // ✅ TEST DB CONNECTION (READ)
    @GetMapping
    public List<SpendCategory> getAllActiveCategories() {
        return repository.findByIsActiveTrue();
    }

    // ✅ CREATE DATA
    @PostMapping
    public SpendCategory create(@RequestBody SpendCategory category) {
        category.setActive(true);
        return repository.save(category);
    }
}
