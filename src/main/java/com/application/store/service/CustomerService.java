package com.application.store.service;

import com.application.store.dto.CustomerData;
import com.application.store.dto.CustomerRegistratinoData;
import com.application.store.model.Customer;
import com.application.store.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    @Override
    public CustomerData createCustomer(CustomerRegistratinoData customerRegistratinoData) {
        Customer customer = new Customer(customerRegistratinoData);
        customerRepository.save(customer);
        return new CustomerData(customer);
    }
}
