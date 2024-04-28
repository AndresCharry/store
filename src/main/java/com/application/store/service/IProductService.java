package com.application.store.service;

import com.application.store.dto.ProductData;
import com.application.store.dto.ProductRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    public ProductData createProduct(ProductRegistrationData productRegistrationData);
    public Page<ProductData> getPageAllProducts(Pageable pageable);
    public ProductData getProductById(Long id);
    public ProductData updateProduct(Long id, ProductRegistrationData productRegistrationData);
    public void deleteProduct(Long id);
}
