package com.application.store.dto;

import com.application.store.model.Sale;

import java.time.LocalDate;
import java.util.List;

public record SaleData(
        Long Id,
        CustomerData customer,
        LocalDate date,
        List<DetailsRegistrationData> details
) {
}
