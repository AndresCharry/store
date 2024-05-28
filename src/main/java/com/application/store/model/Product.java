package com.application.store.model;

import com.application.store.dto.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "available_quantity", nullable = false)
    private Integer availableQuantity;

    @OneToMany(mappedBy = "product")
    private List<SaleDetails> saleDetails;

    public Product(ProductRequestDTO productRequestDTO) {
        this.name = productRequestDTO.name();
        this.brand = productRequestDTO.brand();
        this.unitPrice = productRequestDTO.unitPrice();
        this.availableQuantity = productRequestDTO.availableQuantity();
    }

    public Product(Long productId) {
        this.id = productId;
    }

    public void updateData(ProductRequestDTO productRequestDTO) {
        if (productRequestDTO.name() != null)
            this.name = productRequestDTO.name();
        if (productRequestDTO.brand() != null)
            this.brand = productRequestDTO.brand();
        if (productRequestDTO.unitPrice() != null)
            this.unitPrice = productRequestDTO.unitPrice();
        if (productRequestDTO.availableQuantity() != null)
            this.availableQuantity = productRequestDTO.availableQuantity();
    }
}

