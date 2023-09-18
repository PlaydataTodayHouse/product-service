package com.example.product.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "reviews")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_content", nullable = false, length = 300)
    private String reviewContent;

    @Column(name = "review_image_url")
    private String reviewImageUrl;

    @Column(name = "product_option_name", nullable = false)
    private String productOptionName;

    @Column(name = "star_grade", nullable = false)
    private Integer starGrade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_review_product"), nullable = false)
    private Product product;

}
