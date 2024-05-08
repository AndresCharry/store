package com.application.store.dto;

import com.application.store.model.Product;

import java.math.BigDecimal;

public record ProductResponseDTO(
   Long id,
   String name,
   String brand,
   BigDecimal unitPrice,
   Double availableQuantity
) {
    public ProductResponseDTO(Product save) {
        this(save.getId(), save.getName(), save.getBrand(), save.getUnitPrice(), save.getAvailableQuantity());
    }
}
