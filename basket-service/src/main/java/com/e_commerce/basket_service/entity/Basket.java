package com.e_commerce.basket_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "baskets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String productsId;
    Integer count;

    @PrePersist
    protected void onCreate() {
        if (count == null) count = 1;
    }
}
