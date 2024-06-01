package com.application.store.model;

import com.application.store.dto.SaleDetailsRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "sales_detail")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaleDetails {

    @EmbeddedId
    private SaleOrderKey id;

    @Column(name = "quantity_product", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price_product", nullable = false)
    private BigDecimal unitPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("saleId")
    @JoinColumn(name = "sale_id")
    @ToString.Exclude
    private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    public SaleDetails(SaleDetailsRequestDTO saleDetailsRequestDTO) {
        this.id = new SaleOrderKey(saleDetailsRequestDTO.productId());
        this.quantity = saleDetailsRequestDTO.quantityProduct();
        this.product = new Product(saleDetailsRequestDTO.productId());
    }

    public BigDecimal getSubtotal(){
        if(this.unitPrice == null)return BigDecimal.ZERO;
        return this.unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

}
