package com.e_commerce.product_service.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Type {
    ICKI("icki"),
    GEYIM("geyim"),
    MEBEL("mebel");

    String value;
}
