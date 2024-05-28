package com.application.store.service;

import com.application.store.dto.ProductResponseDTO;
import com.application.store.dto.ProductRequestDTO;
import com.application.store.model.Product;
import com.application.store.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Transactional
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getPageAllProducts(Pageable pageable) {
        List<Product> Products = productRepository.findAll();
        return new PageImpl<>(Products, pageable, Products.size());
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public Product updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Product product = productRepository.findById(id).orElseThrow();
        product.updateData(productRequestDTO);
        return product;
    }

    @Transactional
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Map<Long, BigDecimal> getProductUnitPrice(List<Long> productsIds) {
        List<Product> products = productRepository.findAllById(productsIds);
        Map<Long, BigDecimal> productUnitPrice = new HashMap<>();
        products.forEach(product ->
            productUnitPrice.put(product.getId(), product.getUnitPrice())
        );
        return productUnitPrice;
    }

    @Transactional
    @Override
    public Map<Long,Integer> getQuantitiesOfProducts(List<Long> productsIds) {
        List<Product> products = productRepository.findAllById(productsIds);
        Map<Long, Integer> quantitiesOfProducts = new HashMap<>();
        products.forEach(product ->
                quantitiesOfProducts.put(product.getId(), product.getAvailableQuantity())
        );
        return quantitiesOfProducts;
    }

    @Transactional
    @Override
    public void updateProducts(List<Product> products) {
        productRepository.saveAll(products);
    }
}
