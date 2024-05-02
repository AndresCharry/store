package com.application.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SaleOrderKey implements Serializable {

    @Column(name = "sale_id")
    private Long saleId;
    @Column(name = "product_id")
    private Long productId;
}
