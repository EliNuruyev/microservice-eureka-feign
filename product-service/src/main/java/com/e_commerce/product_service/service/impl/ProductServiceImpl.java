package com.e_commerce.product_service.service.impl;

import com.e_commerce.product_service.dto.request.ProductCreateRequestDTO;
import com.e_commerce.product_service.dto.response.CategoryResponseDTO;
import com.e_commerce.product_service.dto.response.ProductResponseDTO;
import com.e_commerce.product_service.entity.Category;
import com.e_commerce.product_service.entity.Product;
import com.e_commerce.product_service.repository.CategoryRepository;
import com.e_commerce.product_service.repository.ProductRepository;
import com.e_commerce.product_service.service.inter.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Override
    public void addProduct(ProductCreateRequestDTO requestDTO) {
        Category category = Category.builder()
                .type(requestDTO.category().type())
                .build();
        categoryRepository.save(category);
        Product product = Product.builder()
                .name(requestDTO.name())
                .price(requestDTO.price())
                .category(category)
                .build();
        productRepository.save(product);
    }

    @Override
    public ProductResponseDTO getProductById(String productId) {
        Product product = productRepository.findById(productId).orElseThrow(RuntimeException::new);
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .category(CategoryResponseDTO.builder()
                        .id(product.getCategory().getId())
                        .type(product.getCategory().getType())
                        .build())
                .build();

    }

}
