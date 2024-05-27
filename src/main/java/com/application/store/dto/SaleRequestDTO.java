package com.application.store.dto;

import java.util.List;

public record SaleRequestDTO(
        List<SaleDetailsRequestDTO> saleDetails,
        Long customerId
) {
}
