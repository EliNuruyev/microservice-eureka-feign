package com.e_commerce.basket_service.controller;

import com.e_commerce.basket_service.dto.request.BasketCreateRequestDTO;
import com.e_commerce.basket_service.dto.response.BasketResponseDTO;
import com.e_commerce.basket_service.service.inter.BasketService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/basket")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BasketController {
    BasketService basketService;

    @PostMapping
    public ResponseEntity<String> addItemToBasket(@RequestBody BasketCreateRequestDTO requestDTO) {
    basketService.addItemToBasket(requestDTO);
     return ResponseEntity.ok("Added item to Basket");
    }

    @GetMapping
    public ResponseEntity<List<BasketResponseDTO>> getAllItemsFromBasket() {
        return ResponseEntity.ok(basketService.getAllItemsFromBasket());
    }
}
