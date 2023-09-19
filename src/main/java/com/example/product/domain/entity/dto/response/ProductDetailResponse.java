package com.example.product.domain.entity.dto.response;

import com.example.product.domain.entity.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    private List<ReviewResponse> reviews;

    public ProductDetailResponse(Product product, List<ReviewResponse> reviews) {
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
        this.brand = BrandResponse.of(product.getBrand());
        this.options = product.getOptions().stream()
                .map(OptionResponse::of)
                .toList();
        this.reviews = reviews;
    }

    public static ProductDetailResponse of(Product product, List<Review> reviews) {
        List<ReviewResponse> reviewResponses = reviews.stream()
                .map(ReviewResponse::of)
                .toList();

        return new ProductDetailResponse(product, reviewResponses);
    }

}
