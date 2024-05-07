package com.application.store.dto;

import java.util.List;

public record SaleRegistrationData(
        List<DetailsRegistrationData> details,
        CustomerData customer
) {
}
