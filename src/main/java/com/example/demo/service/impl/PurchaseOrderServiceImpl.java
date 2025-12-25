package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

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

        if (purchaseOrder.getAmount() <= 0) {
            throw new BadRequestException("Amount must be positive");
        }

        if (purchaseOrder.getOrderDate().isAfter(LocalDate.now())) {
            throw new BadRequestException("Date cannot be in future");
        }

        if (!purchaseOrder.getSupplier().getActive()) {
            throw new BadRequestException("Inactive supplier");
        }

        if (!purchaseOrder.getCategory().getActive()) {
            throw new BadRequestException("Inactive category");
        }

        return repository.save(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return repository.findBySupplier_Id(supplierId);
    }
}
