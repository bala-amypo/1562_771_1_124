package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // === CORE DB FIELDS ===
    @Column(name = "year")
    private Integer year;

    private Double percentage;

    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    private DiversityClassification classification;

    // =================================================
    // 🔁 TEST / REPOSITORY COMPATIBILITY FIELD
    // =================================================
    @Transient
    private Integer targetYear;

    // === GETTERS ===
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

    // === SETTERS ===
    public void setId(Long id) {
        this.id = id;
    }

    public void setYear(Integer year) {
        this.year = year;
        this.targetYear = year; // keep in sync
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
    // 🔥 REQUIRED BY REPOSITORY: findByTargetYear()
    // =================================================
    public Integer getTargetYear() {
        return year;
    }

    public void setTargetYear(Integer targetYear) {
        this.targetYear = targetYear;
        this.year = targetYear;
    }

    // =================================================
    // OPTIONAL TEST METHODS (SAFE)
    // =================================================
    public double getTargetPercentage() {
        return percentage;
    }

    public void setTargetPercentage(double percentage) {
        this.percentage = percentage;
    }

    @PrePersist
    public void prePersist() {
        if (active == null) {
            active = true;
        }
    }
}
