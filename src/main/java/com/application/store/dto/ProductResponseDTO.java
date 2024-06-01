package com.application.store.dto;

import com.application.store.model.Product;

import java.math.BigDecimal;

public record ProductResponseDTO(
   Long id,
   String name,
   String brand,
   BigDecimal unitPrice,
   Integer availableQuantity
) {
    public ProductResponseDTO(Product product) {
        this(product.getId(),
             product.getName(),
             product.getBrand(),
             product.getUnitPrice(),
             product.getAvailableQuantity()
        );
    }
}
