package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ REQUIRED BY TESTS
    private Integer year;

    private Double percentage;

    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    private DiversityClassification classification;

    // ===== GETTERS =====

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

    // ===== SETTERS =====

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
}
