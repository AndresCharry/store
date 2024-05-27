package com.application.store.dto;

public record SaleDetailsRequestDTO(
        Integer quantityProduct,
        Long productId
) {
}
