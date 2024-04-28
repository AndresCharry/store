package com.application.store.model;

import com.application.store.dto.CustomerRegistratinoData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String dni;

    public Customer(CustomerRegistratinoData customerRegistratinoData) {
        this.name = customerRegistratinoData.name();
        this.lastName = customerRegistratinoData.lastName();
        this.dni = customerRegistratinoData.dni();
    }
}