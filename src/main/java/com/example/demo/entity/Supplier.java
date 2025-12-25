package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private boolean active = true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(
            mappedBy = "supplier",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<DiversityClassification> diversityClassifications = new HashSet<>();

    @PrePersist
    void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        active = true;
    }

    @PreUpdate
    void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // ===== HELPERS =====
    public void addClassification(DiversityClassification dc) {
        diversityClassifications.add(dc);
        dc.setSupplier(this);
    }

    public void removeClassification(DiversityClassification dc) {
        diversityClassifications.remove(dc);
        dc.setSupplier(null);
    }

    // ===== GETTERS / SETTERS =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Set<DiversityClassification> getDiversityClassifications() {
        return diversityClassifications;
    }

    public void setDiversityClassifications(Set<DiversityClassification> diversityClassifications) {
        this.diversityClassifications = diversityClassifications;
    }
}
