package com.example.product.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ParentCategory {
    ELECTRONICS("1000", "전자제품"),
    FURNITURE("2000", "가구"),
    FABRIC("3000", "패브릭");

    private final String code;
    private final String description;
}