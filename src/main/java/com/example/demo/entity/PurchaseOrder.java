package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

public class PurchaseOrder {

    private Long id;

    private String poNumber;

    
    private Supplier supplier;

    
    private SpendCategory category;

    private BigDecimal amount;

    private Date dateIssued;

    private String approvedBy;
    private String notes;

}
