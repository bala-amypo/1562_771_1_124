package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DiversityClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @PrePersist
    void prePersist() {
        active = true;
        if (code != null) {
            code = code.toUpperCase();
        }
    }

    // ===== GETTERS / SETTERS =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
}
