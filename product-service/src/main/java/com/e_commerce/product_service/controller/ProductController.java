package com.e_commerce.product_service.controller;

import com.e_commerce.product_service.dto.request.ProductCreateRequestDTO;
import com.e_commerce.product_service.dto.response.ProductResponseDTO;
import com.e_commerce.product_service.service.inter.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class ProductController {
    ProductService productService;
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductCreateRequestDTO requestDTO) {
        productService.addProduct(requestDTO);
        return ResponseEntity.ok("Product created");
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
}
