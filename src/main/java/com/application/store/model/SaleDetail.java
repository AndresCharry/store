package com.application.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "sales_detail")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleDetail {

    @EmbeddedId
    private SaleOrderKey id;
    private Integer quantity;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "sale_id")
    private Sale sale;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    public BigDecimal getSubtotal(){
        if(this.unitPrice == null)return BigDecimal.ZERO;
        return this.unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

}
