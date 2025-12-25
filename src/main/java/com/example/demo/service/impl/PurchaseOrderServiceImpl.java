package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.entity.Supplier;
import com.example.demo.entity.SpendCategory;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final SupplierRepository supplierRepository;
    private final SpendCategoryRepository spendCategoryRepository;

    // ✅ REQUIRED BY TESTS
    public PurchaseOrderServiceImpl(
            PurchaseOrderRepository purchaseOrderRepository,
            SupplierRepository supplierRepository,
            SpendCategoryRepository spendCategoryRepository
    ) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.supplierRepository = supplierRepository;
        this.spendCategoryRepository = spendCategoryRepository;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {

        if (purchaseOrder.getAmount() == null ||
                purchaseOrder.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be positive");
        }

        if (purchaseOrder.getDateIssued() == null ||
                purchaseOrder.getDateIssued().isAfter(LocalDate.now())) {
            throw new BadRequestException("Date cannot be in future");
        }

        Supplier supplier = purchaseOrder.getSupplier();
        if (supplier == null || !Boolean.TRUE.equals(supplier.getActive())) {
            throw new BadRequestException("Inactive supplier");
        }

        SpendCategory category = purchaseOrder.getCategory();
        if (category == null || !Boolean.TRUE.equals(category.getActive())) {
            throw new BadRequestException("Inactive category");
        }

        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return purchaseOrderRepository.findBySupplier_Id(supplierId);
    }
}
