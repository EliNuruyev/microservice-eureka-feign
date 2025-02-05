package com.e_commerce.basket_service.dto.response;

import lombok.Builder;

@Builder
public record ProductResponseDTO(
        String id,
        String name,
        Double price
) {
}