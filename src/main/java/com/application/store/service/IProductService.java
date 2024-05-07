package com.application.store.service;

import com.application.store.dto.ProductData;
import com.application.store.dto.ProductRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IProductService {
    ProductData createProduct(ProductRegistrationData productRegistrationData);
    Page<ProductData> getPageAllProducts(Pageable pageable);
    List<ProductData> getAllProducts();
    ProductData getProductById(Long id);
    ProductData updateProduct(Long id, ProductRegistrationData productRegistrationData);
    void deleteProduct(Long id);
    Map<Long, BigDecimal> getProductUnitPrice(List<Long> productIds);
}
