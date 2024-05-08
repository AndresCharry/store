package com.application.store.model;

import com.application.store.dto.CustomerResponseDTO;
import com.application.store.dto.CustomerRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;

    public Customer(CustomerRequestDTO customerRequestDTO) {
        this.name = customerRequestDTO.name();
        this.lastName = customerRequestDTO.lastName();
        this.dni = customerRequestDTO.dni();
    }

    public Customer(CustomerResponseDTO customer) {
        this.id=customer.id();
    }

    public void updateData(CustomerRequestDTO customerRequestDTO) {
        if (customerRequestDTO.name() != null)
            this.name = customerRequestDTO.name();
        if (customerRequestDTO.lastName() != null)
            this.lastName = customerRequestDTO.lastName();
        if (customerRequestDTO.dni() != null)
            this.dni = customerRequestDTO.dni();
    }
}
