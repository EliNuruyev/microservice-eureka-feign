package com.e_commerce.basket_service.dto.response;

import lombok.Builder;

@Builder
public record BasketResponseDTO(
        String id,
        String productId,
        String name,
        Double price,
        Integer count
) {
}
