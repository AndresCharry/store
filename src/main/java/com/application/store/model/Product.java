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

    public Product(ProductRegistrationData data) {
        this.name = data.name();
        this.brand = data.brand();
        this.price = data.price();
        this.availableQuantity = data.availableQuantity();
    }
}
