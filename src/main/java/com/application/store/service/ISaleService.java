package com.application.store.service;

import com.application.store.dto.SaleData;
import com.application.store.dto.SaleRegistrationData;

public interface ISaleService {
    public SaleData createSale(SaleRegistrationData saleRegistrationData);
}
