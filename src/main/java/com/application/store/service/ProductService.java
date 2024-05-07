package com.application.store.service;

import com.application.store.dto.ProductData;
import com.application.store.dto.ProductRegistrationData;
import com.application.store.model.Product;
import com.application.store.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public ProductData createProduct(ProductRegistrationData productRegistrationData) {
        return new ProductData(productRepository.save(new Product(productRegistrationData)));
    }

    @Override
    public Page<ProductData> getPageAllProducts(Pageable pageable) {
        List<ProductData> ProductsData = productRepository.findAll()
                                                          .stream()
                                                          .map(ProductData::new)
                                                          .toList();
        return new PageImpl<>(ProductsData, pageable, ProductsData.size());
    }

    @Override
    public List<ProductData> getAllProducts() {
        return productRepository.findAll()
                                .stream()
                                .map(ProductData::new)
                                .toList();
    }

    @Override
    public ProductData getProductById(Long id) {
        return new ProductData(productRepository.getReferenceById(id));
    }

    @Override
    public ProductData updateProduct(Long id, ProductRegistrationData productRegistrationData) {
        Product product = productRepository.getReferenceById(id);
        product.updateData(productRegistrationData);
        return new ProductData(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Map<Long, BigDecimal> getProductUnitPrice(List<Long> productIds) {
        List<Product> products = productRepository.findAllById(productIds);
        Map<Long, BigDecimal> productUnitPrice = new HashMap<>();
        products.forEach(product ->
            productUnitPrice.put(product.getId(), product.getUnitPrice())
        );
        return productUnitPrice;
    }
}
