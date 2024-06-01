package com.application.store.model;

import com.application.store.dto.CustomerResponseDTO;
import com.application.store.dto.CustomerRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(name = "dni", nullable = false, length = 50)
    private String dni;

    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;

    public Customer(CustomerRequestDTO customerRequestDTO) {
        this.name = customerRequestDTO.name();
        this.lastName = customerRequestDTO.lastName();
        this.dni = customerRequestDTO.dni();
    }

    public Customer(Long CustomerId) {
        this.id = CustomerId;
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
