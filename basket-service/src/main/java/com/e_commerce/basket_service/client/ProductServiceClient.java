package com.e_commerce.basket_service.client;

import com.e_commerce.basket_service.dto.response.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product-service",path = "api/v1/products")
public interface ProductServiceClient {

    @GetMapping("/{id}")
     ResponseEntity<ProductResponseDTO> getProductById(@PathVariable String id);
}
