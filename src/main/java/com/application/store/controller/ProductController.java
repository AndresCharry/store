package com.application.store.controller;

import com.application.store.dto.ProductData;
import com.application.store.dto.ProductRegistrationData;
import com.application.store.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<ProductData> createProduct (@RequestBody @Valid ProductRegistrationData productRegistrationData) {
        return ResponseEntity.ok(productService.createProduct(productRegistrationData));
    }

    @GetMapping("")
    public ResponseEntity<Page<ProductData>> getPageAllProducts(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(productService.getPageAllProducts(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductData> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping("/edit/{id}")
    @Transactional
    public ResponseEntity<ProductData> updateProduct(@PathVariable Long id,
                                                     @RequestBody @Valid ProductRegistrationData productRegistrationData) {
        return ResponseEntity.ok(productService.updateProduct(id, productRegistrationData));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}