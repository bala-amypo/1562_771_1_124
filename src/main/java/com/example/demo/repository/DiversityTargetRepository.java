package com.example.demo.repository;

import com.example.demo.entity.DiversityTarget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiversityTargetRepository extends JpaRepository<DiversityTarget, Long> {

    // REQUIRED for t15_get_targets_by_year
    List<DiversityTarget> findByYear(Integer year);
}
