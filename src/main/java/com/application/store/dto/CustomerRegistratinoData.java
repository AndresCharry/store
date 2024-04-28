package com.application.store.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerRegistratinoData(
        @NotBlank String name,
        @NotBlank String lastName,
        @NotBlank String dni
) {
}
