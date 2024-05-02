package com.application.store.model;

import com.application.store.dto.ProductRegistrationData;
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

    public Product(ProductRegistrationData productRegistrationData) {
        this.name = productRegistrationData.name();
        this.brand = productRegistrationData.brand();
        this.unitPrice = productRegistrationData.unitPrice();
        this.availableQuantity = productRegistrationData.availableQuantity();
    }

    public void updateData(ProductRegistrationData productRegistrationData) {
        this.name = productRegistrationData.name();
        this.brand = productRegistrationData.brand();
        this.unitPrice = productRegistrationData.unitPrice();
        this.availableQuantity = productRegistrationData.availableQuantity();
    }
}
