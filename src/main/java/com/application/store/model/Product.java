package com.application.store.model;

import com.application.store.dto.ProductResponseDTO;
import com.application.store.dto.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "available_quantity")
    private Double availableQuantity;
    @OneToMany(mappedBy = "product")
    private List<SaleDetail> details;

    public Product(ProductRequestDTO productRequestDTO) {
        checkProduct(productRequestDTO);
    }

    public void updateData(ProductRequestDTO productRequestDTO) {
        checkProduct(productRequestDTO);
    }

    private void checkProduct(ProductRequestDTO productRequestDTO) {
        if (productRequestDTO.id() != null)
            this.id = productRequestDTO.id();
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
