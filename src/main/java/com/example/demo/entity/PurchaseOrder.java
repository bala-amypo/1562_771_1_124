package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String poNumber;

    private BigDecimal amount;

    private LocalDate dateIssued;

    private String notes;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private SpendCategory category;
}
