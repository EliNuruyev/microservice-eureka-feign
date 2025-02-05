package com.e_commerce.basket_service.service.inter;

import com.e_commerce.basket_service.dto.request.BasketCreateRequestDTO;
import com.e_commerce.basket_service.dto.response.BasketResponseDTO;

import java.util.List;

public interface BasketService {
    void addItemToBasket(BasketCreateRequestDTO requestDTO);
    List<BasketResponseDTO> getAllItemsFromBasket();
}
