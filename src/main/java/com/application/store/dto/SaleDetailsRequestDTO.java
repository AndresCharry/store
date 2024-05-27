package com.application.store.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record SaleDetailsRequestDTO(
        @Min(value = 0)
        Integer quantityProduct,
        @NotNull
        Long productId
) {
}
