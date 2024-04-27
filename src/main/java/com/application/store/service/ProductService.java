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

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public ProductData create (ProductRegistrationData data) {
        return new ProductData(productRepository.save(new Product(data)));
    }

    @Override
    public Page<ProductData> getPageAllProducts(Pageable pageable) {
        List<ProductData> ProductsData = productRepository.findAll()
                                                          .stream()
                                                          .map(ProductData::new)
                                                          .toList();
        return new PageImpl<>(ProductsData, pageable, ProductsData.size());
    }
}
