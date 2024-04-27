package com.application.store.service;

import com.application.store.dto.ProductData;
import com.application.store.dto.ProductRegistrationData;
import com.application.store.model.Product;
import com.application.store.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public ProductData create (ProductRegistrationData data) {
        return new ProductData(productRepository.save(new Product(data)));
    }
}
