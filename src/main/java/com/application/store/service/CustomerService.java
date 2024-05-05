package com.application.store.service;

import com.application.store.dto.CustomerData;
import com.application.store.dto.CustomerRegistratinoData;
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
    public CustomerData createCustomer(CustomerRegistratinoData customerRegistratinoData) {
        Customer customer = new Customer(customerRegistratinoData);
        customerRepository.save(customer);
        return new CustomerData(customer);
    }

    @Override
    public Page<CustomerData> getPageAllCustomers(Pageable pageable) {
        List<CustomerData> customersData = customerRepository.findAll()
                                                             .stream()
                                                             .map(CustomerData::new)
                                                             .toList();
        return new PageImpl<>(customersData, pageable, customersData.size());
    }

    public List<CustomerData> getAllCustomers() {
        return customerRepository.findAll()
                                 .stream()
                                 .map(CustomerData::new)
                                 .toList();
    }

    @Override
    public CustomerData getCustomerById(Long id) {
        return new CustomerData(customerRepository.getReferenceById(id));
    }

    @Override
    public CustomerData updateCustomer(Long id, CustomerRegistratinoData customerRegistratinoData) {
        Customer customer = customerRepository.getReferenceById(id);
        customer.updateData(customerRegistratinoData);
        return new CustomerData(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
