package com.application.store.dto;

import com.application.store.model.Customer;

public record CustomerResponseDTO(
        Long id,
        String name,
        String lastName,
        String dni
) {
    public CustomerResponseDTO(Customer customer) {
        this(customer.getId(), customer.getName(), customer.getLastName(), customer.getDni());
    }
}
