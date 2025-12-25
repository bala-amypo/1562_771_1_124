package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // === CORE FIELDS ===
    private Integer year;
    private Double percentage;
    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    private DiversityClassification classification;

    // === STANDARD GETTERS ===
    public Long getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public Double getPercentage() {
        return percentage;
    }

    public Boolean getActive() {
        return active;
    }

    public DiversityClassification getClassification() {
        return classification;
    }

    // === STANDARD SETTERS ===
    public void setId(Long id) {
        this.id = id;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setClassification(DiversityClassification classification) {
        this.classification = classification;
    }

    // =================================================
    // 🔁 TEST-COMPATIBILITY METHODS (DO NOT REMOVE)
    // =================================================

    public void setTargetYear(int year) {
        this.year = year;
    }

    public int getTargetYear() {
        return year;
    }

    public void setTargetPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getTargetPercentage() {
        return percentage;
    }

    @PrePersist
    public void preSave() {
        if (active == null) {
            active = true;
        }
    }
}
