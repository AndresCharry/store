package com.application.store.service;

import com.application.store.dto.CustomerRequestDTO;
import com.application.store.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService {
    Customer createCustomer(Customer customer);
    Page<Customer> getPageAllCustomers(Pageable pageable);
    Customer getCustomerById(Long id);
    Customer updateCustomer(Long id, CustomerRequestDTO customerRequestDTO);
    void deleteCustomer(Long id);
}
