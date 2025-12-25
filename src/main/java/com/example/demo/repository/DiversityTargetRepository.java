package com.example.demo.repository;

import com.example.demo.entity.DiversityTarget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiversityTargetRepository extends JpaRepository<DiversityTarget, Long> {

    // ✅ REQUIRED BY SERVICE & TESTS
    List<DiversityTarget> findByYear(Integer year);

    // ✅ SAFE TO KEEP (IF USED ANYWHERE)
    List<DiversityTarget> findByTargetYear(Integer targetYear);
}
