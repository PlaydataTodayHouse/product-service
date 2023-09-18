package com.example.product.service;

import com.example.product.config.TokenInfo;
import com.example.product.domain.entity.Brand;
import com.example.product.domain.entity.dto.request.brand.BrandCreateRequest;
import com.example.product.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    @Transactional
    public void save(BrandCreateRequest request, TokenInfo tokenInfo) {
        Brand brand = Brand.builder()
                .brandImageUrl(request.getBrandImageUrl())
                .brandName(request.getBrandName())
                .brandIntroduction(request.getBrandIntroduction())
                .build();

        brandRepository.save(brand);
    }

}
