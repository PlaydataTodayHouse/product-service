package com.example.product.domain.entity.dto.response;

import com.example.product.domain.entity.Delivery;
import com.example.product.domain.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProductResponse {

    private Long productId;
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
    private Delivery delivery;

    // 로그인 사용자인 경우 찜 여부 체크 아니면 false
    private Boolean isWish;

    private BrandResponse brand;

    public static ProductResponse of(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getCategoryId(),
                product.getProductImageUrl(),
                product.getProductName(),
                product.getProductContent(),
                product.getCompany(),
                product.getCompanyRegistrationNumber(),
                product.getOriginalPrice(),
                product.getDiscountRate(),
                product.getTotalQuantity(),
                product.getSalesCount(),
                product.getWishCount(),
                product.getViewCount(),
                product.getReviewAvg(),
                product.getReviewCount(),
                product.getIsSoldOut(),
                product.getIsSelling(),
                product.getDelivery(),
                false,
                BrandResponse.of(product.getBrand())
        );
    }

}

