package com.example.demo.service;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityTargetService {

    private final DiversityTargetRepository repository;

    public DiversityTargetService(DiversityTargetRepository repository) {
        this.repository = repository;
    }

    public DiversityTarget createTarget(DiversityTarget target) {
        return repository.save(target);
    }

    public List<DiversityTarget> getAllTargets() {
        return repository.findAll();
    }

    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return repository.findByYear(year);
    }

    public void deactivateTarget(Long id) {
        DiversityTarget target = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Target not found"));

        target.setIsActive(false);
        repository.save(target);
    }
}
