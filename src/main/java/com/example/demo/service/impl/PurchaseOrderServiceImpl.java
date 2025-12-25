package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository repository;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {

        // ✅ amount must be positive
        if (purchaseOrder.getAmount() == null ||
                purchaseOrder.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be positive");
        }

        // ✅ date must not be in future
        if (purchaseOrder.getDateIssued() == null ||
                purchaseOrder.getDateIssued().isAfter(LocalDate.now())) {
            throw new BadRequestException("Date cannot be in future");
        }

        // ✅ supplier must be active
        if (purchaseOrder.getSupplier() == null ||
                Boolean.FALSE.equals(purchaseOrder.getSupplier().getIsActive())) {
            throw new BadRequestException("Inactive supplier");
        }

        // ✅ category must be active
        if (purchaseOrder.getCategory() == null ||
                Boolean.FALSE.equals(purchaseOrder.getCategory().getActive())) {
            throw new BadRequestException("Inactive category");
        }

        return repository.save(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return repository.findBySupplier_Id(supplierId);
    }
}
