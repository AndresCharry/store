package com.application.store.service;

import com.application.store.dto.ProductData;
import com.application.store.dto.ProductRegistrationData;

public interface IProductService {
    public ProductData create(ProductRegistrationData data);
}
