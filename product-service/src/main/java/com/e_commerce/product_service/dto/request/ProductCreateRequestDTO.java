package com.e_commerce.product_service.dto.request;

import com.e_commerce.product_service.entity.Category;
import lombok.Builder;

@Builder
public record ProductCreateRequestDTO(
        String name,
        Double price,
        CategoryCreateRequestDTO category
) {
}
