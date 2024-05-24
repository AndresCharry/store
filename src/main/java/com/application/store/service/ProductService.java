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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return new ProductResponseDTO(productRepository.save(new Product(productRequestDTO)));
    }

    @Override
    public Page<ProductResponseDTO> getPageAllProducts(Pageable pageable) {
        List<ProductResponseDTO> ProductsData = productRepository.findAll()
                                                          .stream()
                                                          .map(ProductResponseDTO::new)
                                                          .toList();
        return new PageImpl<>(ProductsData, pageable, ProductsData.size());
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return new ProductResponseDTO(productRepository.getReferenceById(id));
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Product product = productRepository.getReferenceById(id);
        product.updateData(productRequestDTO);
        return new ProductResponseDTO(product);
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
