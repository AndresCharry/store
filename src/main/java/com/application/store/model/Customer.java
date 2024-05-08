package com.application.store.model;

import com.application.store.dto.CustomerResponseDTO;
import com.application.store.dto.CustomerRequesteDTO;
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

    public Customer(CustomerRequesteDTO customerRequesteDTO) {
        this.name = customerRequesteDTO.name();
        this.lastName = customerRequesteDTO.lastName();
        this.dni = customerRequesteDTO.dni();
    }

    public Customer(CustomerResponseDTO customer) {
        this.id=customer.id();
    }

    public void updateData(CustomerRequesteDTO customerRequesteDTO) {
        if (customerRequesteDTO.name() != null)
            this.name = customerRequesteDTO.name();
        if (customerRequesteDTO.lastName() != null)
            this.lastName = customerRequesteDTO.lastName();
        if (customerRequesteDTO.dni() != null)
            this.dni = customerRequesteDTO.dni();
    }
}
