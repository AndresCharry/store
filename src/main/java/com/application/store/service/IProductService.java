package com.application.store.service;

import com.application.store.dto.ProductResponseDTO;
import com.application.store.dto.ProductRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IProductService {
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    Page<ProductResponseDTO> getPageAllProducts(Pageable pageable);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);
    void deleteProduct(Long id);
    Map<Long, BigDecimal> getProductUnitPrice(List<Long> productIds);
}
