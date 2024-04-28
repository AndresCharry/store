package com.application.store.dto;

import com.application.store.model.Customer;

public record CustomerData(
        Long id,
        String name,
        String lastName,
        String dni
) {
    public CustomerData(Customer customer) {
        this(customer.getId(), customer.getName(), customer.getLastName(), customer.getDni());
    }
}
