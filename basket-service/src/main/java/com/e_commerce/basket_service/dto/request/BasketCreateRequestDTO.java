package com.e_commerce.basket_service.dto.request;

public record BasketCreateRequestDTO(
        String productId,
        Integer count
) {
}
