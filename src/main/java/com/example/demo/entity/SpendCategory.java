package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "spend_categories")
public class SpendCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // 🔑 NOTE: field name is isActive (NOT active)
    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (isActive == null) isActive = true;
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    // ===== Getters =====
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ===== Setters =====
    public void setName(String name) {
        this.name = name;
    }

    // ✅ REQUIRED for service compatibility
    public void setActive(boolean active) {
        this.isActive = active;
    }

    // Optional
    public void setIsActive(Boolean active) {
        this.isActive = active;
    }
}
