package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository diversityTargetRepository;

    public DiversityTargetServiceImpl(DiversityTargetRepository diversityTargetRepository) {
        this.diversityTargetRepository = diversityTargetRepository;
    }

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        return diversityTargetRepository.save(target);
    }

    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        // 🔥 MUST MATCH REPOSITORY METHOD
        return diversityTargetRepository.findByYear(year);
    }

    @Override
    public DiversityTarget getTargetById(Long id) {
        return diversityTargetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Target not found"));
    }

    @Override
    public DiversityTarget updateTarget(Long id, DiversityTarget target) {
        DiversityTarget existing = getTargetById(id);
        existing.setYear(target.getYear());
        existing.setPercentage(target.getPercentage());
        existing.setActive(target.getActive());
        existing.setClassification(target.getClassification());
        return diversityTargetRepository.save(existing);
    }

    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget target = getTargetById(id);
        target.setActive(false);
        diversityTargetRepository.save(target);
    }
}
