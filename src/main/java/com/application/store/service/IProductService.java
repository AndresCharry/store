package com.application.store.service;

import com.application.store.dto.ProductRequestDTO;
import com.application.store.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IProductService {
    Product createProduct(Product product);
    Page<Product> getPageAllProducts(Pageable pageable);
    Product getProductById(Long id);
    Product updateProduct(Long id, ProductRequestDTO productRequestDTO);
    void deleteProduct(Long id);
    Map<Long, Product> getMapProducts(List<Long> Product);
    void updateProducts(List<Product> values);
}
