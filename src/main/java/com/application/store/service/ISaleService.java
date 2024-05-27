package com.application.store.service;

import com.application.store.dto.SaleResponseDTO;
import com.application.store.dto.SaleRequestDTO;

public interface ISaleService {
    SaleResponseDTO createSale(SaleRequestDTO saleRequestDTO);
}
