package com.example.product.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_image_url", nullable = false)
    private String brandImageUrl;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @Column(name = "brand_introduction", nullable = false)
    private String brandIntroduction;

}
