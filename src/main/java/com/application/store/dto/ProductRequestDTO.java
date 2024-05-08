package com.application.store.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank String name,
        @NotBlank String brand,
        @Min(value = 1) BigDecimal unitPrice,
        @Min(value = 1) Double availableQuantity
) {
}
