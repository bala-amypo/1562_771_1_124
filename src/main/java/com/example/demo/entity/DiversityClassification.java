package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_classification")
public class DiversityClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean active = true;

    // ===== Constructors =====
    public DiversityClassification() {
    }

    public DiversityClassification(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
