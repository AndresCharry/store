package com.application.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleOrderKey implements Serializable {

    @Column(name = "sale_id")
    private Long saleId;
    @Column(name = "product_id")
    private Long productId;

    public SaleOrderKey(Long productId) {
        this.productId = productId;
    }
}
