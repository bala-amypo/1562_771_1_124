package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository diversityTargetRepository;

    public DiversityTargetServiceImpl(DiversityTargetRepository diversityTargetRepository) {
        this.diversityTargetRepository = diversityTargetRepository;
    }
}
