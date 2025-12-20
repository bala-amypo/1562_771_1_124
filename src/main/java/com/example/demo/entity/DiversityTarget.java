package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Double targetPercentage;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // ===== Lifecycle =====
    @PrePersist
    public void prePersist() {
        if (isActive == null) isActive = true;
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    // ===== Getters =====
    public Long getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public Double getTargetPercentage() {
        return targetPercentage;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ===== Setters =====
    public void setYear(Integer year) {
        this.year = year;
    }

    public void setTargetPercentage(Double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    // ✅ REQUIRED for Spring + your Service code
    public void setActive(boolean active) {
        this.isActive = active;
    }

    // Optional (still useful)
    public void setIsActive(Boolean active) {
        this.isActive = active;
    }
}
