package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer targetYear;
    private Double targetPercentage;
    private Boolean isActive = true;

    @ManyToOne
    private DiversityClassification classification;

    @PrePersist
    public void preSave() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getTargetYear() { return targetYear; }
    public void setTargetYear(Integer targetYear) { this.targetYear = targetYear; }

    public Double getTargetPercentage() { return targetPercentage; }
    public void setTargetPercentage(Double targetPercentage) { this.targetPercentage = targetPercentage; }

    public Boolean getActive() { return isActive; }
    public void setIsActive(Boolean active) { this.isActive = active; }

    public DiversityClassification getClassification() { return classification; }
    public void setClassification(DiversityClassification classification) {
        this.classification = classification;

        public void setActive(boolean active) {
    this.isActive = active;
}

    }
}
