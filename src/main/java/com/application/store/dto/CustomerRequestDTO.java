package com.application.store.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerRequestDTO(
        @NotBlank String name,
        @NotBlank String lastName,
        @NotBlank String dni
) {
}
