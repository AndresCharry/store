package com.application.store.controller;

import com.application.store.dto.ProductResponseDTO;
import com.application.store.dto.ProductRequestDTO;
import com.application.store.model.Product;
import com.application.store.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct (@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        Product product = new Product(productRequestDTO);
        return ResponseEntity.ok(new ProductResponseDTO(productService.createProduct(product)));
    }

    @GetMapping("")
    public ResponseEntity<Page<ProductResponseDTO>> getPageAllProducts(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(productService.getPageAllProducts(pageable).map(ProductResponseDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(new ProductResponseDTO(productService.getProductById(id)));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id,
                                                            @RequestBody @Valid ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(new ProductResponseDTO(productService.updateProduct(id, productRequestDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}