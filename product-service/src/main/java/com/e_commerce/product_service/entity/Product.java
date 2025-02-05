package com.e_commerce.product_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "products")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @Column(name = "product_name")
    String name;
    String status;
    Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
    @PrePersist
    protected void onCreate() {
        status = "A";
    }

}
