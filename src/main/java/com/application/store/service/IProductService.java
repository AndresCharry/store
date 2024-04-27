package com.application.store.service;

import com.application.store.dto.ProductData;
import com.application.store.dto.ProductRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    public ProductData create(ProductRegistrationData data);
    public Page<ProductData> getPageAllProducts(Pageable pageable);
}
