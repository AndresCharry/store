package com.application.store.service;

import com.application.store.dto.CustomerData;
import com.application.store.dto.CustomerRegistratinoData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    public CustomerData createCustomer(CustomerRegistratinoData customerRegistratinoData);
    public Page<CustomerData> getPageAllCustomers(Pageable pageable);
    public CustomerData getCustomerById(Long id);
}
