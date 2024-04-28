package com.application.store.model;

import com.application.store.dto.ProductRegistrationData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    private BigDecimal price;
    @Column(name = "available_quantity")
    private Double availableQuantity;

    public Product(ProductRegistrationData productRegistrationData) {
        this.name = productRegistrationData.name();
        this.brand = productRegistrationData.brand();
        this.price = productRegistrationData.price();
        this.availableQuantity = productRegistrationData.availableQuantity();
    }

    public void updateData(ProductRegistrationData productRegistrationData) {
        this.name = productRegistrationData.name();
        this.brand = productRegistrationData.brand();
        this.price = productRegistrationData.price();
        this.availableQuantity = productRegistrationData.availableQuantity();
    }
}
