package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deactivateSupplier(Long id) {
        Supplier supplier = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found"));
        supplier.setActive(false);
        repository.save(supplier);
    }
}
