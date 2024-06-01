package com.application.store.service;

import com.application.store.model.Product;
import com.application.store.model.Sale;
import com.application.store.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService {

    private final IProductService productService;
    private final ISaleRepository saleRepository;

    @Transactional
    @Override
    public Sale createSale(Sale sale) {
        System.out.println(sale);
        setSaleInSaleDetails(sale);
        setUnitPriceInSaleDetails(sale);
        updateAvailableQuantityOfProduct(sale);
        saleRepository.save(sale);
        System.out.println(sale);
        return sale;
    }

    private void setSaleInSaleDetails(Sale sale) {
        sale.getSaleDetails().forEach(saleDetails -> saleDetails.setSale(sale));
    }

    private void setUnitPriceInSaleDetails(Sale sale) {
        List<Long> productsIds = productsIds(sale);
        Map<Long, Product> MapProducts = productService.getMapProducts(productsIds);
        sale.getSaleDetails().forEach(saleDetail -> saleDetail.setUnitPrice(MapProducts.get(
                saleDetail.getProduct().getId()).getUnitPrice()
        ));
    }

    private void updateAvailableQuantityOfProduct(Sale sale) {
        List<Long> productsIds = productsIds(sale);
        Map<Long, Product> mapProducts = productService.getMapProducts(productsIds);
        sale.getSaleDetails()
                .forEach(saleDetail -> {
                    Long productId = saleDetail.getProduct().getId();
                    int newAvailableQuantity = mapProducts.get(productId).getAvailableQuantity() - saleDetail.getQuantity();
                    if (newAvailableQuantity < 0) throw new RuntimeException("insufficient quantity");
                    mapProducts.get(productId).setAvailableQuantity(newAvailableQuantity);
                });
        System.out.println(mapProducts.values());
        productService.updateProducts(mapProducts.values().stream().toList());
    }

    private List<Long> productsIds (Sale sale){
        return sale.getSaleDetails()
                .stream()
                .map(saleDetail -> saleDetail.getProduct().getId())
                .toList();
    }
}
