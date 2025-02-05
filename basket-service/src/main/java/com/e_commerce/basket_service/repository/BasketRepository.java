package com.e_commerce.basket_service.repository;

import com.e_commerce.basket_service.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends JpaRepository<Basket, String> {
    Optional<Basket> findByProductsId(String productId);
}
