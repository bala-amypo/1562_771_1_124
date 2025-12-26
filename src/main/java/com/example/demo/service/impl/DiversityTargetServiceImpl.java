package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
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

    // ✅ CREATE
    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        return repository.save(target);
    }

    // ✅ GET BY YEAR
    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return repository.findByYear(year);
    }

    // ✅ GET ALL (THIS WAS MISSING ❌)
    @Override
    public List<DiversityTarget> getAllTargets() {
        return repository.findAll();
    }

    // ✅ DEACTIVATE
    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget target = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Target not found"));

        target.setActive(false);
        repository.save(target);
    }
}
