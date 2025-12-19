package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;

@Service
public class DiversityClassificationServiceImpl implements DiversityClassificationService {

    private final DiversityClassificationRepository diversityClassificationRepository;

    public DiversityClassificationServiceImpl(
            DiversityClassificationRepository diversityClassificationRepository) {
        this.diversityClassificationRepository = diversityClassificationRepository;
    }
}
