package com.e_commerce.product_service.dto.response;

import lombok.Builder;

@Builder
public record ProductResponseDTO(
        String id,
        String name,
        Double price,
        CategoryResponseDTO category
) {
}
