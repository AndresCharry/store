package com.application.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleOrderKey {

    @Column(name = "sale_id")
    private Long saleId;
    @Column(name = "product_id")
    private Long productId;
}
