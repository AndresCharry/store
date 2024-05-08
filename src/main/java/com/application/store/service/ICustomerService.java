package com.application.store.service;

import com.application.store.dto.CustomerResponseDTO;
import com.application.store.dto.CustomerRequesteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    CustomerResponseDTO createCustomer(CustomerRequesteDTO customerRequesteDTO);
    Page<CustomerResponseDTO> getPageAllCustomers(Pageable pageable);
    List<CustomerResponseDTO> getAllCustomers();
    CustomerResponseDTO getCustomerById(Long id);
    CustomerResponseDTO updateCustomer(Long id, CustomerRequesteDTO customerRequesteDTO);
    void deleteCustomer(Long id);
}
