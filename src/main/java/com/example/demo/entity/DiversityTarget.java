package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =================================================
    // 🔥 THIS FIELD NAME MUST MATCH REPOSITORY METHOD
    // =================================================
    @Column(name = "year")
    private Integer targetYear;

    private Double percentage;

    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    private DiversityClassification classification;

    // ================= GETTERS =================
    public Long getId() {
        return id;
    }

    public Integer getTargetYear() {
        return targetYear;
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

    // ================= SETTERS =================
    public void setId(Long id) {
        this.id = id;
    }

    public void setTargetYear(Integer targetYear) {
        this.targetYear = targetYear;
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

    // ================= TEST COMPATIBILITY =================
    public void setYear(Integer year) {
        this.targetYear = year;
    }

    public Integer getYear() {
        return targetYear;
    }

    public void setTargetPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getTargetPercentage() {
        return percentage;
    }

    @PrePersist
    public void prePersist() {
        if (active == null) {
            active = true;
        }
    }
}
