package com.application.store.service;

import com.application.store.dto.SaleData;
import com.application.store.dto.SaleRegistrationData;
import com.application.store.model.Sale;
import com.application.store.model.SaleOrderKey;
import com.application.store.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService {

    private final IProductService productService;
    private final ISaleRepository saleRepository;

    @Override
    public SaleData createSale(SaleRegistrationData saleRegistrationData) {
        Sale sale = new Sale(saleRegistrationData);
        System.out.println(sale);
        sale.getDetails().forEach(System.out::println);
        setInformationDetails(sale);
        System.out.println(sale);
        saleRepository.save(sale);
        return null;
    }

    private void setInformationDetails(Sale sale) {
        setId(sale);
        setUnitPrice(sale);
        //setSale(sale);
    }

    private void setId(Sale sale) {
        sale.getDetails().forEach(saleDetail -> saleDetail.setId(new SaleOrderKey(
                 saleDetail.getProduct().getId()
        )));
    }

    private void setSale(Sale sale) {
        sale.getDetails().forEach(saleDetail -> saleDetail.setSale(sale));
    }

    private void setUnitPrice(Sale sale) {
        List<Long> productIds = sale.getDetails().stream().map(saleDetail -> saleDetail.getProduct()
                                                                                       .getId())
                                                                                       .toList();
        Map<Long, BigDecimal> productUnitPrice = productService.getProductUnitPrice(productIds);
        sale.getDetails().forEach(saleDetail -> saleDetail.setUnitPrice(productUnitPrice.get(
                saleDetail.getProduct().getId()
        )));
    }
}
