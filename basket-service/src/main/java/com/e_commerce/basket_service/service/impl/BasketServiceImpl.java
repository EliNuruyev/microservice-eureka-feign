package com.e_commerce.basket_service.service.impl;

import com.e_commerce.basket_service.client.ProductServiceClient;
import com.e_commerce.basket_service.dto.request.BasketCreateRequestDTO;
import com.e_commerce.basket_service.dto.response.BasketResponseDTO;
import com.e_commerce.basket_service.dto.response.ProductResponseDTO;
import com.e_commerce.basket_service.entity.Basket;
import com.e_commerce.basket_service.repository.BasketRepository;
import com.e_commerce.basket_service.service.inter.BasketService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BasketServiceImpl implements BasketService {
    BasketRepository basketRepository;
    ProductServiceClient productServiceClient;

    @Override
    public void addItemToBasket(BasketCreateRequestDTO requestDTO) {
        ProductResponseDTO productResponseDTO = productServiceClient.getProductById(requestDTO.productId()).getBody();
        if (productResponseDTO != null) {
            Optional<Basket> basketOptional = basketRepository.findByProductsId(requestDTO.productId());
            if (basketOptional.isPresent()) {
                Basket basket = basketOptional.get();
                basket.setCount(basket.getCount() + 1);
                basketRepository.save(basket);
            } else {
                basketRepository.save(
                        Basket.builder()
                                .productsId(requestDTO.productId())
                                .build()
                );
            }

        }
    }

    @Override
    public List<BasketResponseDTO> getAllItemsFromBasket() {
        List<Basket> AllItemsFromBasket = basketRepository.findAll();
        return AllItemsFromBasket.stream().map(
                basketItem -> {
                    ProductResponseDTO productResponseDTO = productServiceClient
                            .getProductById(basketItem.getProductsId())
                            .getBody();
                    return BasketResponseDTO.builder()
                            .id(basketItem.getId())
                            .productId(basketItem.getProductsId())
                            .count(basketItem.getCount())
                            .name(productResponseDTO.name())
                            .price(productResponseDTO.price())
                            .build();
                }
        ).toList();
    }
}
