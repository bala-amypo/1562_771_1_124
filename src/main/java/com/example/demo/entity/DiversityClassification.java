package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_classification")
public class DiversityClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private boolean active;

    @PrePersist
    public void preSave() {
        this.active = true;
    }

    // ✅ REQUIRED BY TESTS
    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
