package com.application.store.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SaleRequestDTO(
        @NotNull
        List<SaleDetailsRequestDTO> saleDetails,
        @NotNull
        Long customerId
) {
}
