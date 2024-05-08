package com.application.store.controller;

import com.application.store.dto.CustomerResponseDTO;
import com.application.store.dto.CustomerRequesteDTO;
import com.application.store.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody @Valid CustomerRequesteDTO customerRequesteDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequesteDTO));
    }

    @GetMapping("")
    public ResponseEntity<Page<CustomerResponseDTO>> getPageAllCustomers(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(customerService.getPageAllCustomers(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/edit/{id}")
    @Transactional
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@PathVariable("id") Long id,
                                                              @RequestBody @Valid CustomerRequesteDTO customerRequesteDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerRequesteDTO));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
