package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 ONLY REAL FIELD USED BY JPA
    private Integer year;

    private Double percentage;

    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    private DiversityClassification classification;

    // ========= JPA GETTERS =========
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

    // ========= JPA SETTERS =========
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

    // ========= TEST COMPATIBILITY =========
    public Integer getTargetYear() {
        return year;
    }

    public void setTargetYear(Integer year) {
        this.year = year;
    }

    public double getTargetPercentage() {
        return percentage;
    }

    public void setTargetPercentage(double percentage) {
        this.percentage = percentage;
    }

    @PrePersist
public void preSave() {
    if (active == null) {
        active = true;
    }


    }
}
