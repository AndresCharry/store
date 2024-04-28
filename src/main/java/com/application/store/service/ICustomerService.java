package com.application.store.service;

import com.application.store.dto.CustomerData;
import com.application.store.dto.CustomerRegistratinoData;

public interface ICustomerService {
    public CustomerData createCustomer(CustomerRegistratinoData customerRegistratinoData);
}
