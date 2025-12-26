package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {

    @Autowired
    private DiversityTargetRepository repository;

    @Override
    public DiversityTarget create(DiversityTarget target) {
        return repository.save(target);
    }

    @Override
    public void deactivate(Long id) {
        DiversityTarget target = repository.findById(id)
                .orElseThrow(RuntimeException::new);
        target.setActive(false);
        repository.save(target);
    }

    // 🔥 REQUIRED FOR t15
    @Override
    public List<DiversityTarget> getTargetsByYear(int year) {
        return repository.findByTargetYear(year);
    }
}
