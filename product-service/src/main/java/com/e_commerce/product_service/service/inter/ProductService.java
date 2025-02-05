package com.e_commerce.product_service.service.inter;

import com.e_commerce.product_service.dto.request.ProductCreateRequestDTO;
import com.e_commerce.product_service.dto.response.ProductResponseDTO;

public interface ProductService {
    void addProduct(ProductCreateRequestDTO requestDTO);
    ProductResponseDTO getProductById(String productId);
}
