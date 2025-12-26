package com.example.demo.service;

import com.example.demo.entity.DiversityTarget;

import java.util.List;

public interface DiversityTargetService {

    DiversityTarget createTarget(DiversityTarget target);

    List<DiversityTarget> getTargetsByYear(Integer year);

    List<DiversityTarget> getAllTargets();   // ✅ REQUIRED BY CONTROLLER

    void deactivateTarget(Long id);
}
