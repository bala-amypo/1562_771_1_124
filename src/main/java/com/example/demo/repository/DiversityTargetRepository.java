package com.example.demo.repository;

import com.example.demo.entity.DiversityTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiversityTargetRepository extends JpaRepository<DiversityTarget, Long> {

    // 🔹 Service usage
    List<DiversityTarget> findByYear(Integer year);

    // 🔹 TEST COMPATIBILITY (DO NOT REMOVE)
    List<DiversityTarget> findByTargetYear(int year);
}
