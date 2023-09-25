package com.example.product.domain.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String categoryId;
    private String productImageUrl;
    private String productName;
    private String productContent;
    private String company;
    private String companyRegistrationNumber;
    private Integer originalPrice;
    private Integer discountRate;
    private Integer totalQuantity;
    private Integer salesCount;
    private Integer wishCount;
    private Integer viewCount;
    private Double reviewAvg;
    private Integer reviewCount;
    private Boolean isSoldOut;
    private Boolean isSelling;
    private String deliveryType;
    private Long brandId;

}