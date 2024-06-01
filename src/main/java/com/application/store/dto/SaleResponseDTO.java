package com.application.store.dto;


import com.application.store.model.Sale;
import com.application.store.model.SaleDetails;

import java.time.LocalDate;
import java.util.List;

public record SaleResponseDTO(
        Long Id,
        LocalDate date,
        List<SaleDetailsResponseDTO> details,
        Long customer
) {
    public SaleResponseDTO(Sale sale){
        this(sale.getId(),
             sale.getDate(),
             sale.getSaleDetails().stream().map(SaleDetailsResponseDTO::new).toList(),
             sale.getCustomer().getId()
        );
    }
}
