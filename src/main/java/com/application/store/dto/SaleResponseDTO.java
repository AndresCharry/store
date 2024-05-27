package com.application.store.dto;


import java.time.LocalDate;
import java.util.List;

public record SaleResponseDTO(
        Long Id,
        Long customer,
        LocalDate date,
        List<SaleDetailsRequestDTO> details
) {
}
