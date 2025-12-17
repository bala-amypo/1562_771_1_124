package com.example.demo.entity;

public class Supplier {

    
    private Long id;

    private String name;

    private String registrationNumber;

    private String email;

    private String phone;
    private String address;

    private List<DiversityClassification> diversityClassifications;

    private Boolean isActive = true;

    private Timestamp createdAt;
    private Timestamp updatedAt;
    public void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    public void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
