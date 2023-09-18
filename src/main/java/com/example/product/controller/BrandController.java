package com.example.product.controller;

import com.example.product.auth.UserTokenInfo;
import com.example.product.config.TokenInfo;
import com.example.product.domain.entity.dto.request.brand.BrandCreateRequest;
import com.example.product.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/brand")
@Validated
public class BrandController {

    private final BrandService brandService;

    @PostMapping
    public void save(
            @Valid @RequestBody BrandCreateRequest request,
            @UserTokenInfo TokenInfo tokenInfo
    ) {
        brandService.save(request, tokenInfo);
    }

}
