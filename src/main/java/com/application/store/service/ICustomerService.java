package com.application.store.service;

import com.application.store.dto.CustomerData;
import com.application.store.dto.CustomerRegistratinoData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    CustomerData createCustomer(CustomerRegistratinoData customerRegistratinoData);
    Page<CustomerData> getPageAllCustomers(Pageable pageable);
    List<CustomerData> getAllCustomers();
    CustomerData getCustomerById(Long id);
    CustomerData updateCustomer(Long id, CustomerRegistratinoData customerRegistratinoData);
    void deleteCustomer(Long id);
}
