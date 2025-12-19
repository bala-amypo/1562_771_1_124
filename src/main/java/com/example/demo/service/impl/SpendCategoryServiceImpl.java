package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.SpendCategoryService;

@Service
public class SpendCategoryServiceImpl implements SpendCategoryService {

    private final SpendCategoryRepository spendCategoryRepository;

    public SpendCategoryServiceImpl(SpendCategoryRepository spendCategoryRepository) {
        this.spendCategoryRepository = spendCategoryRepository;
    }
}
