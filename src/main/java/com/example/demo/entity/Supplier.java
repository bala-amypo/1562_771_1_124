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

    private String name;

    private String registrationNumber;

    private String email;

    // IMPORTANT: Boolean (not boolean)
    private Boolean isActive = true;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "supplier_diversity",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns = @JoinColumn(name = "diversity_id")
    )
    private Set<DiversityClassification> diversityClassifications = new HashSet<>();

    // ================== ID ==================

    public Long getId() {
        return id;
    }

    // REQUIRED BY TESTS
    public void setId(Long id) {
        this.id = id;
    }

    // ================== BASIC FIELDS ==================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ================== ACTIVE FLAG ==================
    // BOTH versions are REQUIRED (tests + services)

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // 🔥 REQUIRED BY SERVICES
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        this.isActive = active;
    }

    // ================== TIMESTAMPS ==================

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // ================== RELATIONS ==================

    public Set<DiversityClassification> getDiversityClassifications() {
        return diversityClassifications;
    }

    // ================== LIFECYCLE ==================

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        if (this.isActive == null) {
            this.isActive = true;
        }
    }
}
