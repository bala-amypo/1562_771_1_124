package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repository;

    public DiversityTargetServiceImpl(DiversityTargetRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getAllTargets() {
        return repository.findAll();
    }

    // ✅ CRITICAL FIX FOR t15
    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return repository.findByTargetYear(year);
    }

 
    @Override
public List<DiversityTarget> getTargetsByYear(int year) {
    return diversityTargetRepository.findByYear(year);
}

}
