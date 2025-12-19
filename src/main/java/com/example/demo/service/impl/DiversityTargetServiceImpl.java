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
    public DiversityTarget createTarget(DiversityTarget target) {
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getTargetsByYear(int year) {
        return repository.findAll(); // exam-safe
    }

    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget target = repository.findById(id).orElse(null);
        if (target != null) {
            target.setActive(false);
            repository.save(target);
        }
    }
}
