package com.e_commerce.product_service.dto.response;

import com.e_commerce.product_service.enums.Type;
import lombok.Builder;

@Builder
public record CategoryResponseDTO(
        String id,
        Type type
) {
}
