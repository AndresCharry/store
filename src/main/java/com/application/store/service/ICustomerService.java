package com.application.store.service;

import com.application.store.dto.CustomerResponseDTO;
import com.application.store.dto.CustomerRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequesteDTO);
    Page<CustomerResponseDTO> getPageAllCustomers(Pageable pageable);
    List<CustomerResponseDTO> getAllCustomers();
    CustomerResponseDTO getCustomerById(Long id);
    CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO customerRequesteDTO);
    void deleteCustomer(Long id);
}
