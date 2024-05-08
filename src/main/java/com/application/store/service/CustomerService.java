package com.application.store.service;

import com.application.store.dto.CustomerResponseDTO;
import com.application.store.dto.CustomerRequesteDTO;
import com.application.store.model.Customer;
import com.application.store.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequesteDTO customerRequesteDTO) {
        Customer customer = new Customer(customerRequesteDTO);
        customerRepository.save(customer);
        return new CustomerResponseDTO(customer);
    }

    @Override
    public Page<CustomerResponseDTO> getPageAllCustomers(Pageable pageable) {
        List<CustomerResponseDTO> customersData = customerRepository.findAll()
                                                             .stream()
                                                             .map(CustomerResponseDTO::new)
                                                             .toList();
        return new PageImpl<>(customersData, pageable, customersData.size());
    }

    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll()
                                 .stream()
                                 .map(CustomerResponseDTO::new)
                                 .toList();
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id) {
        return new CustomerResponseDTO(customerRepository.getReferenceById(id));
    }

    @Override
    public CustomerResponseDTO updateCustomer(Long id, CustomerRequesteDTO customerRequesteDTO) {
        Customer customer = customerRepository.getReferenceById(id);
        customer.updateData(customerRequesteDTO);
        return new CustomerResponseDTO(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
