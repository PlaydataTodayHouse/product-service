package com.example.product.domain.entity.dto.response;

import com.example.product.domain.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProductDetailResponse {

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
    private Delivery delivery;

    // 로그인 사용자인 경우 찜 여부 체크 아니면 false
    private Boolean isWish;

    private BrandResponse brand;

    private List<OptionResponse> options;

    public ProductDetailResponse(Product product, Brand brand, Option option, OptionDetail optionDetail, Review review) {
        this.productId = product.getId();
        this.categoryId = product.getCategoryId();
        this.productImageUrl = product.getProductImageUrl();
        this.productName = product.getProductName();
        this.productContent = product.getProductContent();
        this.company = product.getCompany();
        this.companyRegistrationNumber = product.getCompanyRegistrationNumber();
        this.originalPrice = product.getOriginalPrice();
        this.discountRate = product.getDiscountRate();
        this.totalQuantity = product.getTotalQuantity();
        this.salesCount = product.getSalesCount();
        this.wishCount = product.getWishCount();
        this.viewCount = product.getViewCount();
        this.reviewAvg = product.getReviewAvg();
        this.reviewCount = product.getReviewCount();
        this.isSoldOut = product.getIsSoldOut();
        this.isSelling = product.getIsSelling();
        this.delivery = product.getDelivery();
        this.brand = BrandResponse.of(brand);
//        this.options = List.of(new OptionResponse(option, optionDetail));
    }
}
