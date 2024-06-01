package com.application.store.dto;

import com.application.store.model.SaleDetails;

public record SaleDetailsResponseDTO(
        Integer quantityProduct,
        Long productId
) {
        public SaleDetailsResponseDTO(SaleDetails saleDetails){
                this(saleDetails.getQuantity(), saleDetails.getProduct().getId());

        }
}
