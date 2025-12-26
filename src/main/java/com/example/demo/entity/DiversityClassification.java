package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_classification")
public class DiversityClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // ================= REQUIRED BY TESTS =================

    @PrePersist
    public void preSave() {
        active = true;
        if (code != null) {
            code = code.toUpperCase();
        }
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // ================= GETTERS / SETTERS =================

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
