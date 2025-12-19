package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int targetYear;

    private Double targetPercentage;

    @ManyToOne
    private DiversityClassification classification;

    private Boolean active;

    @PrePersist
    public void preSave() {
        if (active == null) active = true;
    }
}
