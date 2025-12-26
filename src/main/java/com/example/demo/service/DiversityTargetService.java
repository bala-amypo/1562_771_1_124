package com.example.demo.service;

import com.example.demo.entity.DiversityTarget;
import java.util.List;

public interface DiversityTargetService {

    DiversityTarget createTarget(DiversityTarget target);

    List<DiversityTarget> getTargetsByYear(Integer year);

    DiversityTarget getTargetById(Long id);

    DiversityTarget updateTarget(Long id, DiversityTarget target);

    void deactivateTarget(Long id);
}
