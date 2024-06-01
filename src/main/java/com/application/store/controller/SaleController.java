package com.application.store.controller;

import com.application.store.dto.SaleResponseDTO;
import com.application.store.dto.SaleRequestDTO;
import com.application.store.model.Sale;
import com.application.store.service.ISaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {

    private final ISaleService saleService;


    @PostMapping("/create")
    @Transactional
    public ResponseEntity<SaleResponseDTO> createSale(@RequestBody @Valid SaleRequestDTO saleRequestDTO){
        Sale sale = new Sale(saleRequestDTO);
        return ResponseEntity.ok(new SaleResponseDTO(saleService.createSale(sale)));
        //return  ResponseEntity.ok(null);
    }
}
