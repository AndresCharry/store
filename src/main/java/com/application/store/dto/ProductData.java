package com.application.store.dto;

import com.application.store.model.Product;

import java.math.BigDecimal;

public record ProductData(
   Long id,
   String name,
   String brand,
   BigDecimal unitPrice,
   Double availableQuantity
) {
    public ProductData(Product save) {
        this(save.getId(), save.getName(), save.getBrand(), save.getUnitPrice(), save.getAvailableQuantity());
    }
}
