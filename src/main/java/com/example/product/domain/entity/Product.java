package com.example.product.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id", nullable = false)
    private String categoryId;

    @Column(name = "product_image_url", nullable = false)
    private String productImageUrl;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Lob
    @Column(name = "product_content", nullable = false)
    private String productContent;

    @Column(name = "original_price", nullable = false)
    private Integer originalPrice;

    @Column(name = "discount_rate")
    private Integer discountRate;

    @Column(name = "wish_count")
    @Builder.Default
    private Integer wishCount = 0;

    @Column(name = "purchase_count")
    @Builder.Default
    private Integer viewCount = 0;

    @Column(name = "review_avg")
    @Builder.Default
    private Double reviewAvg = 0.0;

    @Column(name = "is_sold_out")
    @Builder.Default
    private Boolean isSoldOut = false;

    @Column(name = "is_selling")
    @Builder.Default
    private Boolean isSelling = true;

    @Column(name = "review_count")
    @Builder.Default
    private Integer reviewCount = 0;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", foreignKey = @ForeignKey(name = "fk_product_brand"), nullable = false)
    private Brand brand;

    // Options options;


}