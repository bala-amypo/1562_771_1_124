package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;

    private Double percentage;

    private Boolean isActive = true;

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

    public Boolean getIsActive() {
        return isActive;
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

    public void setIsActive(Boolean active) {
        this.isActive = active;
    }

    // REQUIRED BY TESTS
    public void setActive(boolean active) {
        this.isActive = active;
    }
}
