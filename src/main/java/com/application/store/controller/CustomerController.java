package com.application.store.controller;

import com.application.store.dto.CustomerRequestDTO;
import com.application.store.dto.CustomerResponseDTO;
import com.application.store.model.Customer;
import com.application.store.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerService.createCustomer(new Customer(customerRequestDTO));
        return ResponseEntity.ok(new CustomerResponseDTO(customer));
    }

    @GetMapping("")
    public ResponseEntity<Page<CustomerResponseDTO>> getPageAllCustomers(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(customerService.getPageAllCustomers(pageable).map(CustomerResponseDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new CustomerResponseDTO(customerService.getCustomerById(id)));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@PathVariable("id") Long id,
                                                              @RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(new CustomerResponseDTO(customerService.updateCustomer(id, customerRequestDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
