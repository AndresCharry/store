package com.application.store.controller;

import com.application.store.dto.CustomerData;
import com.application.store.dto.CustomerRegistratinoData;
import com.application.store.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<CustomerData> createCustomer(@RequestBody @Valid CustomerRegistratinoData customerRegistratinoData) {
        return ResponseEntity.ok(customerService.createCustomer(customerRegistratinoData));
    }
}
