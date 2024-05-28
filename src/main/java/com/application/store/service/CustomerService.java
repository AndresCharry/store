package com.application.store.service;

import com.application.store.dto.CustomerRequestDTO;
import com.application.store.model.Customer;
import com.application.store.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    @Transactional
    @Override
    public Customer createCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Page<Customer> getPageAllCustomers(Pageable pageable) {
        List<Customer> customers = customerRepository.findAll()
                                                     .stream()
                                                     .toList();
        return new PageImpl<>(customers, pageable, customers.size());
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public Customer updateCustomer(Long id, CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.updateData(customerRequestDTO);
        return customer;
    }

    @Transactional
    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
