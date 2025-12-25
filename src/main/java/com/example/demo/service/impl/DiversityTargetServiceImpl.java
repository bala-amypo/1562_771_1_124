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

    @Override
    public DiversityTarget create(DiversityTarget target) {
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getAll() {
        return repository.findAll();
    }

    // 🔥 IMPORTANT: must use repository query (NOT filtering)
    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return repository.findByYear(year);
    }

    @Override
    public void deactivate(Long id) {
        DiversityTarget target = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Target not found"));
        target.setActive(false);
        repository.save(target);
    }
}
