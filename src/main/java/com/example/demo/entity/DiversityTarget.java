package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer targetYear;

    private Double targetPercentage;

    private Boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    private DiversityClassification classification;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // ================= LIFECYCLE =================

    @PrePersist
    public void preSave() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        if (this.isActive == null) {
            this.isActive = true;
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // ================= GETTERS =================

    public Long getId() {
        return id;
    }

    public Integer getTargetYear() {
        return targetYear;
    }

    public Double getTargetPercentage() {
        return targetPercentage;
    }

    public DiversityClassification getClassification() {
        return classification;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // ================= SETTERS =================

    public void setId(Long id) {
        this.id = id;
    }

    public void setTargetYear(Integer targetYear) {
        this.targetYear = targetYear;
    }

    // ✅ alias required by tests
    public void setTargetYear(int year) {
        this.targetYear = year;
    }

    public void setTargetPercentage(Double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    // ✅ alias required by tests
    public void setTargetPercentage(double percentage) {
        this.targetPercentage = percentage;
    }

    public void setClassification(DiversityClassification classification) {
        this.classification = classification;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void setIsActive(Boolean active) {
        this.isActive = active;
    }
}
