package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String role;
    private String fullName;

    private Boolean active;
    private LocalDateTime createdAt;

    public UserAccount() {}

    // ✅ FIXED: Match the parameter order expected by the test
    // Test calls: new UserAccount(1L, "New User", "new@user.com", "password123_ENC", "ADMIN")
    //                              id   fullName     email           password          role
    public UserAccount(Long id, String fullName, String email, String password, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @PrePersist
    public void prePersist() {
        if (this.role == null) {
            this.role = "USER";
        }
        if (this.active == null) {
            this.active = true;
        }
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}