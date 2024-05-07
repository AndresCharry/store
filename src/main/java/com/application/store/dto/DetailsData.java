package com.application.store.dto;


public record DetailsData(
        SaleOrderKeyData id,
        Integer quantity,
        ProductData product
) {
}
