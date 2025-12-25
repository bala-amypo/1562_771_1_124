package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_classification")
public class DiversityClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // ===== REQUIRED BY TESTS =====

    public void preSave() {
        if (active == null) {
            active = true;
        }
        if (code != null) {
            code = code.toUpperCase();
        }
    }

    public Boolean getActive() {
        return active;
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
