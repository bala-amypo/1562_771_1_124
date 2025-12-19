package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "spend_categories")
public class SpendCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean active;

    @PrePersist
    public void preSave() {
        if (active == null) active = true;
    }
}
