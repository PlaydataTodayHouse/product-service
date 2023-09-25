package com.example.product.domain.entity.dto.response;

import com.example.product.domain.entity.Brand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BrandResponse {

    private Long brandId;
    private String brandName;

    public static BrandResponse of(Brand brand) {
        return new BrandResponse(brand.getId(), brand.getBrandName());
    }

}
