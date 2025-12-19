package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;

    private LocalDateTime createdAt;

    public UserAccount() {}

    public UserAccount(Long id, String fullName, String email, String password, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @PrePersist
    public void prePersist() {
        if (role == null) role = "USER";
        createdAt = LocalDateTime.now();
    }
}
